class Solution {
    private static int[] dp = new int[1001];
    public int twoEggDropDP(int n) {
        if(dp[n]==0){
            for(int i=1; i<=n;++i){
                dp[n]=Math.min(dp[n]==0?n:dp[n],1+Math.max(i-1,twoEggDrop(n-i)));
            }
        }
        return dp[n];
    }

    public int twoEggDrop(int n){
        int res = 1;
        while(n-res>0){
            n-=res;
            res++;
        }
        return res;
    }
}