/*
Approach: BFS 

Intuition: 
We can use BFS to caclculate the shortest path. In addition to the basic position coordinates x and y, our BFS state must also track the current energy e, the number of steps taken steps, and the set of already collected litter. We can efficiently represent the collected litter using a bitmask, where each piece of litter is assigned a unique bit identifier starting from 0.

During the search process, move in four directtions from the current state (i, j, mask, e, steps ) and update the state as follows.
- current position newI,newJ
- Collected litter mask: If the current position is 'L', add the identifier of this piece of litter to mask; otherwise the mask remains unchanged.
- If the current position is 'R', update the energy of the current position to enrgy, otherwise update it to e-1.
- Update the steps of the current position too one more than the previous step.


The start point of DFS is (startI, startJ, 0, energy, 0) where, startI, startJ are starting position of student. The target endpoint is any valid state where the mask equals fullMask (representing the collection of all litter).

During the BFS, we use a 3D array bestEnergy[x][y][mask] to record the maximum energy value reached at position x,y for each possible mask state. We only enqueue a new state and update bestEnergy[x][y][mask] if the remaining energy is strictly greater than the previous recorded energy for that configuration. This pruning prevents redundant cycles, such as repeated jumping back and forth between two positions.


*/
class Solution{
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    class Info{
        int i, j, mask, e, steps;
        Info(int i, int j, int mask, int e, int steps){
            this.i = i;
            this.j = j;
            this.mask = mask;
            this.e = e;
            this.steps = steps;
        }
    }
    public int minMoves(String[] classroom, int energy){
        int m = classroom.length, n = classroom[0].length();
        int[][] id = new int[m][n];

        int startI = 0, startJ = 0, cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                char c = classroom[i].charAt(j);
                if(c=='S'){
                    startI = i;
                    startJ = j;
                }else if(c=='L'){
                    id[i][j]=1<<cnt;
                    cnt++;
                }
            }
        }
        int full = 1<<cnt;
        int[][][] bestEnergy = new int[m][n][full];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(bestEnergy[i][j],-1);
            }
        }
        bestEnergy[startI][startJ][0] = energy;

        Deque<Info> q = new ArrayDeque<>();
        q.add(new Info(startI, startJ, 0, energy, 0));

        while(!q.isEmpty()){
            Info t = q.removeFirst();
            if(t.mask==full-1) return t.steps;
            if(t.e==0) continue;
            for(int[] dir:dirs){
                int newI = t.i + dir[0], newJ = t.j + dir[1];
                if(newI<0||newJ<0||newI>=m||newJ>=n||classroom[newI].charAt(newJ)=='X') continue;
                int newEnergy = classroom[newI].charAt(newJ)=='R'?energy:t.e-1;
                int newMask = t.mask | id[newI][newJ];
                if(newEnergy > bestEnergy[newI][newJ][newMask]){
                    bestEnergy[newI][newJ][newMask] = newEnergy;
                    q.addLast(new Info(newI, newJ, newMask, newEnergy, t.steps+1));
                }
            }
        }
        return -1;
    }    

}
class SolutionInitialDoesNotWork {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    char[][] cr;
    int fullEnergy;
    int moves, litters,m,n;
    public int minMoves(String[] classroom, int energy) {
        this.fullEnergy = energy;
        this.moves = Integer.MAX_VALUE;
        this.m = classroom.length;
        this.n = classroom[0].length();
        this.cr = new char[m][n];
        this.litters = 0;
        int startI = 0, startJ = 0;
        for(int i=0;i<m;i++){
            cr[i]=classroom[i].toCharArray();
            for(int j=0;j<n;j++){
                if(cr[i][j]=='L') litters++;
                if(cr[i][j]=='S'){
                    startI= i;
                    startJ=j;
                }
            }
        }
        Set<Integer> visited = new HashSet<>();
        cr[startI][startJ]='.';
        dfs(startI, startJ, fullEnergy, 0, 0,visited);
        return moves==Integer.MAX_VALUE?-1:moves;
    }
    private void dfs(int i, int j, int currEnergy,int consumed,int currMoves, Set<Integer> visited){
        if(consumed == litters){
            moves = Math.min(currMoves, moves);
            return;
        }
        if(currEnergy==0){
            return;
        }        
        visited.add(i*100+j);
        for(int[] dir:dirs){
            int newI = i+dir[0], newJ = j+dir[1];
            if(newI>=m||newJ>=n||newI<0||newJ<0||cr[newI][newJ]=='X'||visited.contains(newI*100+newJ)) continue;
            if(cr[newI][newJ]=='L'){
                cr[newI][newJ]='.';
                dfs(newI,newJ,currEnergy-1, consumed+1, currMoves+1,visited);
                cr[newI][newJ]='L';
            }else if(cr[newI][newJ]=='R'){
                dfs(newI,newJ,fullEnergy, consumed,currMoves+1,visited);
            }else{
                dfs(newI,newJ,currEnergy-1, consumed,currMoves+1,visited);
            }
        }
        visited.remove(i*100+j);
    }
}