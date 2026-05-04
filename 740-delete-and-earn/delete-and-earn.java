class Solution {
    public int deleteAndEarnInitial(int[] nums) {
        int max = 0;
        for(int num:nums) max = Math.max(num,max);
        int[] arr = new int[max+1];
        for(int num:nums) arr[num]++;
        int result = 0;
        int[] dp = new int[max+1];
        dp[0]=0;
        dp[1]= arr[1];
        for(int i=2;i<=max;i++){
            dp[i] = Math.max(dp[i-2]+i*arr[i],dp[i-1]);
        }
        return dp[max];
    }
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num:nums) max = Math.max(num,max);
        int[] arr = new int[max+1];
        for(int num:nums) arr[num]++;

        int t1=0, t2= arr[1];
        for(int i=2;i<=max;i++){
            int temp = t2;
            t2 = Math.max(t1+i*arr[i],t2);
            t1 = temp;
        }
        return t2;
    }
}