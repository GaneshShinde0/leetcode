class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int c:coins){
                if(i-c>=0){
                    // If coin is present it will take dp[0]+1=> which is basically one;
                    dp[i]=Math.min(dp[i-c]+1,dp[i]);
                }
            }
        }
        return dp[amount]==(amount+1)?-1:dp[amount];
    }
}