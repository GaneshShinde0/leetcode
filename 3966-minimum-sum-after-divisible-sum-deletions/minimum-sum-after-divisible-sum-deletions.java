/*
USE DP to track the result, 
dp[prefix%k] stores the smallest result with prefix sum mod k.

Explaination:
- Iterate through the array, maintaining an evolving sum res.
- If res reaches a value that shares a remainder with a smaller previously seen prefix sum, the algorithm instantly deletes the difference
- By setting res to that smaller value.
*/
class Solution {
    public long minArraySum(int[] nums, int k) {
        long[] dp = new long[k];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0]=0;
        long res = 0;
        for(int num:nums){
            res+=num;
            int remainder = (int) (res%k);
            dp[remainder] = Math.min(dp[remainder], res);
            res = Math.min(dp[remainder], res);
        }
        return res;
    }
}