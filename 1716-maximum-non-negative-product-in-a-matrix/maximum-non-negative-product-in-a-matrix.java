class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0}};
    int m,n;
    long res;
    private static final int MOD = 1_000_000_007;
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        res = Integer.MIN_VALUE;
        long[][] dp = new long[m][n];
        dp[0][0] = grid[0][0];
        recurse(dp,grid,0,0);
        return res<0?-1:(int) (res%MOD);
    }

    private void recurse(long[][] dp, int[][] grid, int i, int j){
        if(grid[i][j]==0){
            res = Math.max(res,0);
            return;
        }
        if(i==m-1&&j==n-1){
            // res = Math.max(res,grid[i][j]*dp[i-1][j]);
            // res = Math.max(res,grid[i][j]*dp[i][j-1]);
            res = Math.max(res,dp[i][j]);
        }
        for(int[] dir: dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];
            if(ni>=dp.length||nj>=dp[0].length) continue;
            dp[ni][nj]= ((1l*dp[i][j]*grid[ni][nj]));
            recurse(dp,grid,ni,nj);
        }
    }

    
}