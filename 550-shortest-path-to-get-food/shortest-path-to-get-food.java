class Solution {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='*'){
                    queue.add(new int[]{i,j,0});
                    vis[i][j]=true;
                }
            }
        }
        int shortestDistancce = 0;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int d = curr[2];
            if(grid[i][j]=='#') return d;
            for(int[] dir:dirs){
                int newI = i+dir[0];
                int newJ = j+dir[1];
                if(newI<0||newJ<0||newI>=m||newJ>=n||vis[newI][newJ]) continue;
                vis[newI][newJ] = true;
                if(grid[newI][newJ]=='X') continue;
                queue.add(new int[]{newI,newJ,d+1});
            }
        }
        return -1;
    }
}