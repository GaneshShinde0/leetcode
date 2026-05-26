/*
USE DP to track the result, 
dp[prefix%k] stores the smallest result with prefix sum mod k.

Intuition:
- Iterate through the array, maintaining an evolving sum res.
- If res reaches a value that shares a remainder with a smaller previously seen prefix sum, the algorithm instantly deletes the difference
- By setting res to that smaller value.

Explaination:
- Evolving sum res isn't just a running total, it represents minimum possible sum of the array prefix so far, after optimal deletions.
    res = dp[remainder] = Math.min(dp[remainder], res);
- This compact line looks up the smallest past sum with the same remainder (int) (res%k);
- It compares this past sum with current res and updates DP with new minimum
- It replaces res with this minimum value, which is equivalent to performing optimal deletion. The final value of res after the loop is the minimum possible sum for the entire array.

Time & Space Complexity:
Time: O(N)
Space: O(k)
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
            res = dp[remainder];
        }
        return res;
    }
}