class Solution {
    final int MOD = (int) 1e9+7;
    public int numberOfWays(int amount) {
        int[] coins = new int[]{ 1, 2, 6 };
        int[] dp = new int[amount + 1];

        dp[0] = 1; // 1 way to form amount = 0.

        if(amount >= 4) dp[4] = 1;
        if(amount >= 8) dp[8] = 1;
        
        for(int coin: coins){
            for(int i=1; i<=amount; i++){
                if(coin > i) continue;
                dp[i] += (dp[i-coin]) % MOD; // induction rule. dp[i] = ways to form amount with coin.
            }
        }
        return dp[amount];
    }
}

// TC: SC: O(N)