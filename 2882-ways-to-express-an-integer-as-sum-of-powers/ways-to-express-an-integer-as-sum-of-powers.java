class Solution {
    final int MOD = 1_000_000_007;
    public int numberOfWays200ms(int n, int x) {
        long[][] dp = new long[n+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            long val = (long) Math.pow(i,x);
            for(int j=0;j<=n;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=val){
                    dp[i][j] = (dp[i][j]+dp[i-1][j-(int) val])%MOD;
                }
            }
        }
        return (int) dp[n][n];
    }

    public int numberOfWays139ms(int n, int x){
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            int val = (int) Math.pow(i,x);
            if(val>n) break;
            for(int j=n; j>=val; j--){
                dp[j] = (dp[j]+dp[j-val])%MOD;
            }
        }
        return (int) dp[n];
    }
    public int numberOfWays(int n, int x) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i = 1; Math.pow(i,x) <= n; i++) {
            int num = (int)Math.pow(i,x); // We have calculated one part... With next for loop we are searching for other part.
            for (int s = n; s >= num; s--) {
                dp[s] += dp[s - num];
                // System.out.println(Arrays.toString(dp));
            }
        }
        return (int) (dp[n] % 1_000_000_007);
    }
}