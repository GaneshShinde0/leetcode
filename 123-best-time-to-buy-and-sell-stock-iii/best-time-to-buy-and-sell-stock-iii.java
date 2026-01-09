class Solution {
    public int maxProfitInitial(int[] prices) {
        int n = prices.length;
        if(n<=1) return 0;

        int leftMin = prices[0];
        int rightMax = prices[n-1];

        int[] leftProfits = new int[n];
        int[] rightProfits = new int[n+1]; // Padding right dp arrray with additional 0 for conveniencce.

        // Bidirectional DP Array
        for(int l=1; l<n; ++l){
            leftProfits[l] = Math.max(leftProfits[l-1], prices[l]-leftMin);
            leftMin = Math.min(leftMin, prices[l]);

            int r = n-1-l;
            rightProfits[r] = Math.max(rightProfits[r+1],rightMax-prices[r]);
            rightMax = Math.max(rightMax, prices[r]);
        }

        int maxProfit = 0;
        for(int i=0; i<n; i++){
            maxProfit = Math.max(maxProfit, leftProfits[i]+rightProfits[i+1]);
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices){
        int t1Cost = Integer.MAX_VALUE, t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0, t2Profit = 0;

        for(int price:prices){
            // The maximum profit if only one transaction is allowed
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price-t1Cost);
            // Reinvest gained profit in second transaction
            t2Cost = Math.min(t2Cost, price-t1Profit);
            t2Profit = Math.max(t2Profit, price-t2Cost);
        }

        return t2Profit;
    }
}