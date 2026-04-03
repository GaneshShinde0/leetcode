/*
This is extension of house robber problem. Only difference is that the first and last houses are adjacent to each other and therefore, if the thief has robbed the first house, they cannot steal the last house and vice versa. 
Houses are arranged in circular order.

The problem becomes to rob either house1 to house n-1 or house2 to house n. -> Whatever offers more money.
*/
class Solution {
    public int robInitial(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n-1;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        int res1 = Math.max(dp[n-1],dp[n-2]);
        if(n<=2) return res1;
        Arrays.fill(dp,0);
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return Math.max(res1,dp[n-1]);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max1 = rob_simple(nums, 0, nums.length - 2);
        int max2 = rob_simple(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    public int rob_simple(int[] nums, int start, int end) {
        int t1 = 0;
        int t2 = 0;

        for (int i = start; i <= end; i++) {
            int temp = t1;
            int current = nums[i];
            t1 = Math.max(current + t2, t1);
            t2 = temp;
        }

        return t1;
    }
}