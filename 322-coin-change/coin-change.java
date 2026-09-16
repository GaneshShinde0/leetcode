class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int MAX = amount+1;
        Arrays.fill(dp, MAX);
        dp[0] = 0; // Number of coins to form 0 ammount;
        for(int i=1;i<MAX;i++){
            for(int coin:coins){
                if(i-coin>=0 && dp[i-coin]!=MAX){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[MAX-1]==MAX?-1:dp[MAX-1];
    }
}