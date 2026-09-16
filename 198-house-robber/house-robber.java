class Solution {
    
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return Math.max(dp[n-2], dp[n-1]);
    }
    public int robCheck(int[] nums) {
        int r1 = nums[0], r2 = nums[1], i=2, n=nums.length;
        while(i<n){
            int temp = r1;
            r1 = Math.max(r1+nums[i],r2);
            r2 = Math.max(temp+nums[i], r2);
            i++;
        }
        return Math.max(r1,r2);
    }
}