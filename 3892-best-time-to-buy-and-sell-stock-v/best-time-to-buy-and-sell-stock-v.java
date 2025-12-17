class Solution {
    private int[] prices;
    private long[][][] memo;
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        this.prices = prices;
        // At everytime we can either buy a stock or sell a stock; (We have 3 states Neutral:0, Buy: 1, Sell:2)
        memo = new long[n][k+1][3];
        for(int i=0;i<n;i++){
            for(int j=0; j<=k; j++){
                for(int s = 0; s<3; s++){
                    memo[i][j][s] = -1;
                }
            }
        }
        return dfs(n-1,k, 0);
    }

    private long dfs(int i, int j, int state){
        if(j==0) return 0; // When There are 0 Transactions (k) remaining return 0;
        if(i==0) return state==0?0:(state==1?-prices[0]:prices[0]); // When We are buying and i==0 (curr = -prices[0]) hoping we will have some value > curr in future.
        // For Sell we are hoping we will have some value < curr.(in future)
        if(memo[i][j][state]!=-1) return memo[i][j][state]; // Already calculated value

        int p = prices[i]; // Current Price.
        long res=0;
        if(state == 0){
            res = Math.max(dfs(i-1,j,0),Math.max(dfs(i-1,j,1)+p, dfs(i-1,j,2)-p));
        }else if (state == 1){
            res = Math.max(dfs(i-1,j,1), dfs(i-1,j-1,0)-p);
        }else{
            res = Math.max(dfs(i-1,j,2), dfs(i-1,j-1,0)+p);
        }
        memo[i][j][state] = res;
        return res;
    }
}