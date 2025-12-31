class Solution {
    private static final int[][] dirs = {{0,1},{1,0}};
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        return dfs(obstacleGrid,dp,0,0,m-1, n-1);
    }
    private int dfs(int[][] grid, int[][] dp, int i, int j,int m, int n){       
        int res = 0;
        if(i>m ||j>n||i<0||j<0||grid[i][j]==1) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        if(i==m && j==n) return 1;
        for(int[] dir:dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];
            res +=dfs(grid, dp, ni, nj, m, n);
        }
        dp[i][j] = res;
        return res;
    }
}