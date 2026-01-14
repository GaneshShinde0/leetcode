class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0}};
    int m,n;
    long res;
    private static final int MOD = 1_000_000_007;
    public int maxProductPathRecursion(int[][] grid) {
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
            res = Math.max(res,0); // This pruning moves solution from TLE to working solution.
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

    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        long[][] maxDP = new long[m][n];
        long[][] minDP = new long[m][n];
        
        maxDP[0][0] = minDP[0][0] = grid[0][0];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                
                long val = grid[i][j];
                
                // Initialize current max/min with a value that will definitely be overwritten
                // Or handle edge cases where we are at the first row (i=0) or first col (j=0)
                
                if (i == 0) {
                    // We can only come from the left
                    maxDP[i][j] = maxDP[i][j-1] * val;
                    minDP[i][j] = minDP[i][j-1] * val;
                } else if (j == 0) {
                    // We can only come from the top
                    maxDP[i][j] = maxDP[i-1][j] * val;
                    minDP[i][j] = minDP[i-1][j] * val;
                } else {
                    // Can come from TOP or LEFT
                    // You need to calculate 4 potential candidates:
                    // 1. max from top * val
                    long topMax = maxDP[i-1][j]*val;
                    // 2. min from top * val
                    long topMin = minDP[i-1][j]*val;
                    // 3. max from left * val
                    long leftMax = maxDP[i][j-1]*val;
                    // 4. min from left * val
                    long leftMin = minDP[i][j-1]*val;
                    // TODO: Set maxDP[i][j] to the max of these 4
                    // TODO: Set minDP[i][j] to the min of these 4
                    maxDP[i][j] = Math.max(Math.max(leftMin,topMin),Math.max(topMax,leftMax));
                    minDP[i][j] = Math.min(Math.min(topMax,leftMax),Math.min(topMin,leftMin));
                }
            }
        }
        
        long result = maxDP[m-1][n-1];
        if (result < 0) return -1;
        return (int) (result % 1_000_000_007);
    }
}