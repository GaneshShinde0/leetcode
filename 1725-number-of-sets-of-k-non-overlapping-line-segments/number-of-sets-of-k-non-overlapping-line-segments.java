/*
n - Points
k - segments.

*/
class Solution {
    private int MOD = 1_000_000_007;
    public int numberOfSets(int n, int k) {
        // Number of ways to have j segments ending at ith point.
        int[][] dp = new int[n][k+1];
        // Number of ways to have 0 segments ending at i.
        for(int i=0;i<n;i++) dp[i][0] = 1;
        for(int j=1;j<=k;j++){
            int sum = 0;
            for(int i=1;i<n;i++){
                // Add ways for j-1 segments.
                sum = (sum+dp[i-1][j-1])%MOD;
                // Don't use i or end a segment at i.
                dp[i][j] = (dp[i-1][j] + sum)%MOD;
            }
        }
        return (int) (dp[n-1][k]%MOD);
    }
}