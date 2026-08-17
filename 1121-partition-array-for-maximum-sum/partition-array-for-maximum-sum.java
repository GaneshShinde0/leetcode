class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int res = 0, n = arr.length;
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            int maxVal = 0;
            for(int j=1;j<=k && i>=j;j++){
                maxVal = Math.max(maxVal, arr[i-j]);
                dp[i] = Math.max(dp[i], dp[i-j]+maxVal*j);
                // System.out.println(Arrays.toString(dp));
            }
        }
        return dp[n];
    }
}