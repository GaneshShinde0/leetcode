class Solution {
    final int MOD = 1000000007;
    // n = 30 TLE
    public int numTilingsBruteForce(int n) {
        return dominoes(0,n,false);
    }

    private int dominoes(int i, int n, boolean possible){
        if(i==n) return possible?0:1;
        if(i>n) return 0;
        if(possible){
            return (dominoes(i+1,n,false)+dominoes(i+1,n,true))%MOD;
        }
        return (dominoes(i+1,n,false)+dominoes(i+2,n,false)+2*dominoes(i+2,n,true))%MOD;
    }

    public int numTilings(int n){
        if(n<=1) return 1;
        if(n==2) return 2;
        if(n==3) return 5;
        long[] dp = new long[n+1];
        dp[0]=1;dp[1]=1;dp[2]=2;dp[3]=5;
        for(int i=4;i<=n;i++){
            dp[i]=(2*dp[i-1]+dp[i-3])%MOD;
        }
        return (int) dp[n];
    }
}