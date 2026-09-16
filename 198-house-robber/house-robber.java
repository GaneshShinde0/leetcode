class Solution {
    
    public int robUsingArray(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int r1 = nums[0], r2 = Math.max(nums[1],nums[0]), i=2, n=nums.length;
        while(i<n){
            int temp = r2;
            r2 = Math.max(r1+nums[i], r2);
            r1 = temp;
            i++;
        }
        return r2;
    }
}