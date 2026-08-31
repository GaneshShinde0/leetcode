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
                    int curr = dfs(i,j);
                    res = Math.max(curr,res);
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j){
        int curr = grid[i][j];
        grid[i][j]=0;
        int sub = 0;
        for(int[] dir:dirs){
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if(newI<0||newJ<0||newI>=m||newJ>=n||grid[newI][newJ]==0) continue;
            sub =Math.max(sub,dfs(newI, newJ));
        }
        grid[i][j] = curr;
        return curr+sub;
    }
}