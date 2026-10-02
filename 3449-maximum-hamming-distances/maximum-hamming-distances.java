public class Solution {
    public int[] maxHammingDistances(int[] nums, int m) {
        int size = 1 << m;
        int[] dp = new int[size];
        int[] res = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        
        for (int num : nums) dp[num] = 0;

        for (int bit = 0; bit < m; bit++) {
            int[] prev = dp.clone();
            for (int num = 0; num < size; num++) 
                dp[num] = Math.max(dp[num], prev[num ^ (1 << bit)] + 1);
        }

        for (int i = 0; i < nums.length; i++)
            res[i] = dp[nums[i]];

        return res;
    }
}