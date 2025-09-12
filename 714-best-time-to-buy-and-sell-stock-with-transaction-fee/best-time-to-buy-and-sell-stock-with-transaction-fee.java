class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int res = 0;

        for(int i=1;i<prices.length;i++){
            buy = Math.max(buy,res-prices[i]);
            res = Math.max(res, buy+prices[i]-fee);
        }
        return res;
    }
}