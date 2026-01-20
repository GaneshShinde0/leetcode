class Solution {

    // Memory Optimized
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    public int maxProfitPerformanceOptimized(int[] prices) {
        int n=prices.length;
        int []arr=new int[n];
        int profit=0;

        for(int i=0;i<n-1;++i){
            arr[i]=prices[i+1]-prices[i];        
        }

        for(int i=0;i<n;++i){
            if(arr[i] > 0){
                profit+=arr[i];
            }
        }
        return profit;
    }
}