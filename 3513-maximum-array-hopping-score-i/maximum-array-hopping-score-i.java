class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                dp[j]=Math.max((j-i)*nums[j]+dp[i],dp[j]);
            }
        }
        return dp[n-1];
    }
}