class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int curr = prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i]>curr){
                res = Math.max(res,prices[i]-curr);
            }
            curr=Math.min(prices[i],curr);
        }
        return res;
    }
}