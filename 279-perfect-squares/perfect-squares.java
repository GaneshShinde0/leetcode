class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1); // So basically we are checking our current solution with previous integer's solution. if there exists solution for i-j*j we will use that .. otherwise no
                /* For 0 it will be 0 ... for 1 it will be 1, for 2 it will be 1+1, for three it will be 1+1+1 for four it will be 1 (as 2*2 = 4)  */
            }
        }
        return dp[n];
    }
}