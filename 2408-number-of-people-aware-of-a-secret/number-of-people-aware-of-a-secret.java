class Solution {
    private static final int MOD = 1000000007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n];
        dp[0]=1;
        long total = 0;
        for(int i=delay;i<n;i++){
            total +=dp[i-delay];
            dp[i] = total%MOD;
            if(i-forget+1>=0){
                total-=dp[i-forget+1];
            }
        }
        long res =0;
        for(int i=n-forget; i<n; i++){
            res = (res+dp[i])%MOD;
        }
        return (int)res;
        
    }
}