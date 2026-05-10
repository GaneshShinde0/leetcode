class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -n);//        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for(int j=1;j<n;j++){
            for(int i=0;i<j;i++){
                if(Math.abs(nums[i]-nums[j])<=target){
                    dp[j]=Math.max(dp[i]+1,dp[j]);
                }
            }
        }
        
        return dp[n-1]<0?-1:dp[n-1];
    }

    
    public int lengthOfLIS1(int[] arr) {
        int n = arr.length;
        int[] lisLength = new int[n];
        Arrays.fill(lisLength,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    lisLength[i] = Math.max(lisLength[j]+1,lisLength[i]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i:lisLength){
            res = Math.max(i,res);
        }
        return res;
    }
}