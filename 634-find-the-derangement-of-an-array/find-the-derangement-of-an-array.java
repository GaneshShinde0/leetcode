class Solution {
    private static final int MOD = 1000000007;
    public int findDerangement(int n) {
        if (n==1) return 0;
        int res = 1;
        long[] dp = new long[n+1];
        dp[1]=0;
        dp[2]=1;
        for(int i = 3;i<=n;i++){
            dp[i]=((i-1)*((dp[i-1]+dp[i-2])%MOD))%MOD;
        }
        // System.out.println(Arrays.toString(dp));
        return (int) dp[n];
    }
}