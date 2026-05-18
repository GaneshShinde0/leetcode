class SolutionInitial{
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
class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int res = 0, max = 0;
        for(int i=n-1;i>0;i--){
            max = Math.max(max,nums[i]);
            res+=max;
        }
        return res;
    }
}