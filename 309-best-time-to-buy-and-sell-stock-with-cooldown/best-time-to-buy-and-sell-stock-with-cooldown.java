class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, prev_sell=0, buy = Integer.MIN_VALUE, prev_buy;
        for(int price:prices){
            prev_buy = buy;
            buy = Math.max(prev_sell-price, prev_buy);
            prev_sell = profit;
            profit = Math.max(prev_buy+price,prev_sell);
        }
        return profit;
    }
}