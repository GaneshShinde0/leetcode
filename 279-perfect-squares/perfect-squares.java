class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1); // So basically we are checking our current solution with previous integer's solution. if there exists solution for i-j*j we will use that .. otherwise no
            }
        }
        return dp[n];
    }
}