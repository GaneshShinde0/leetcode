class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num:nums) max = Math.max(num,max);
        int[] arr = new int[max+1];
        for(int num:nums) arr[num]++;
        int result = 0;
        int[] dp = new int[max+1];
        dp[0]=0;
        dp[1]= Math.max(arr[1],arr[0]);
        for(int i=2;i<=max;i++){
            dp[i] = Math.max(dp[i-2]+i*arr[i],dp[i-1]);
        }
        return dp[max];
    }
}