class Solution {
    public int maxProfit(int[] prices) {
        int res =0, currMin = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            currMin = Math.min(currMin,prices[i]);
            res = Math.max(prices[i]-currMin,res);
        }        
        return res;
    }
}