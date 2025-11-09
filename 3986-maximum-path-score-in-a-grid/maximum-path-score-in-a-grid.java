class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];
        int[][] score = new int[m][n];
        
        // Precompute cost and score
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    cost[i][j] = 0;
                    score[i][j] = 0;
                } else if (grid[i][j] == 1) {
                    cost[i][j] = 1;
                    score[i][j] = 1;
                } else { // grid[i][j] == 2
                    cost[i][j] = 1;
                    score[i][j] = 2;
                }
            }
        }

        // Initialize DP with -1 (unreachable)
        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], -1);

        // Base case
        dp[0][0][cost[0][0]] = score[0][0];

        // Fill DP
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == -1) continue;
                    
                    // Move Down
                    if (i + 1 < m) {
                        int nc = c + cost[i + 1][j];
                        if (nc <= k)
                            dp[i + 1][j][nc] = Math.max(dp[i + 1][j][nc],
                                    dp[i][j][c] + score[i + 1][j]);
                    }
                    
                    // Move Right
                    if (j + 1 < n) {
                        int nc = c + cost[i][j + 1];
                        if (nc <= k)
                            dp[i][j + 1][nc] = Math.max(dp[i][j + 1][nc],
                                    dp[i][j][c] + score[i][j + 1]);
                    }
                }
            }
        }

        // Find max score at destination
        int res = -1;
        for (int c = 0; c <= k; c++)
            res = Math.max(res, dp[m - 1][n - 1][c]);

        return res;
    }
}
