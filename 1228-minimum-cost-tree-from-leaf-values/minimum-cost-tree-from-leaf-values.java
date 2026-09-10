class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] maxInRange = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE/4);
            dp[i][i] = 0;
            int max = arr[i];
            for(int j=i;j<n;j++){
                max = Math.max(max, arr[j]);
                maxInRange[i][j] = max;
            }
        }
        for(int len = 2; len<=n; len++){
            for(int i=0;i+len-1<n;i++){
                int j = i+len-1;
                for(int k=i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][k] + dp[k+1][j] + maxInRange[i][k] * maxInRange[k+1][j], dp[i][j]); 
                }
            }
        }
        return dp[0][n-1];
    }
}