class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        long lastMinus = Integer.MIN_VALUE;
        long lastPlus = Integer.MIN_VALUE;
        long res = Integer.MIN_VALUE;
        for(int num: nums) {
            long currPlus = Math.max(lastMinus + num, num);
            lastMinus = lastPlus - num;           
            lastPlus = currPlus;
            res = Math.max(res, Math.max(lastMinus, lastPlus));
        }
        return res;
    }
}