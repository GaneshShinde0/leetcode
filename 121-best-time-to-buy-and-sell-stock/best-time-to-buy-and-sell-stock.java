class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, minPrice = prices[0];
        for(int price: prices){
            profit = Math.max(profit, price-minPrice);
            minPrice = Math.min(price, minPrice);
        }
        return profit;
    }
}