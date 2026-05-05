/*

We have to group most high difficulty jobs together so that we can come up with best approach.
Example:

1,5,5,5,1,5,5,5,1 => 
Given 5 days then best way would be.
1, 5, 1, 5, 1

1,5,5,5,1,5,5,5,1 => 
Given 5 days then best way would be.
1, 5, 1, 5, 1


*/

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;
        int[][] dp = new int[d + 1][n + 1];
        for (int[] a : dp) Arrays.fill(a, 1000000);
        dp[0][0] = 0;
        for (int i = 1; i <= d; i++) {
            for (int j = i; j <= n; j++) {
                int max = 0;
                for (int k = j; k>=i; k--) {
                    max = Math.max(max, jobDifficulty[k-1]);
                    if (dp[i - 1][k - 1] != 1000000) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k-1]+max);
                    }
                }
            }
        }
        return dp[d][n];
    }
}