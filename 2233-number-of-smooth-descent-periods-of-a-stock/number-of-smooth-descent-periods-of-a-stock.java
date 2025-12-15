class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        long result = 1;
        int curr = 1;
        for(int i=1;i<prices.length;i++){
            if(prices[i]+1==prices[i-1]){
                curr++;
                result+=curr;
            }else{
                curr=1;
                result+=curr;
            }
        }
        return result;
    }
}