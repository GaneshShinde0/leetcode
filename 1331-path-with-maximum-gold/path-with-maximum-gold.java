class Solution {
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int m,n;
    int[][] grid;
    public int getMaximumGold(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    Set<Integer> set = new HashSet<>();
                    set.add(i*100+j);
                    int curr = dfs(i,j,set);
                    res = Math.max(curr,res);
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j, Set<Integer> set){
        int curr = grid[i][j];
        int sub = 0;
        for(int[] dir:dirs){
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if(newI<0||newJ<0||newI>=m||newJ>=n||set.contains(newI*100+newJ) || grid[newI][newJ]==0) continue;
            set.add(newI*100+newJ);
            sub =Math.max(sub,dfs(newI, newJ, set));
            set.remove(newI*100+newJ);
        }
        return curr+sub;
    }
}