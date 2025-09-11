class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp = new int[amount+1];
        int n = coins.length;
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int c:coins){
                if(i-c>=0 ) dp[i]=Math.min(dp[i-c]+1,dp[i]);
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount]==amount+1?-1:dp[amount];
    }
}