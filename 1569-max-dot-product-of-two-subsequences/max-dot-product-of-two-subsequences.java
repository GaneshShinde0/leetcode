class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int[] d:dp){
            // for(int i=1;i<d.length;i++) d[i]=Integer.MIN_VALUE;
            Arrays.fill(d, -1000000000); 
        }
        // int[] temp = dp[0];
        // Arrays.fill(temp, 0);
        int sum = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int curr = nums1[i-1]*nums2[j-1];
                // Up i, j-1
                // Left i-1, j
                // prev i-1, j-1
                int up = dp[i][j-1];
                int left = dp[i-1][j];
                int prev = dp[i-1][j-1];
                int maxUpLeft=Math.max(up,left);
                dp[i][j] = Math.max(dp[i-1][j-1]+curr,curr); // This needs to be added first otherwise answer will get overwritten.
                dp[i][j] = Math.max(dp[i][j],maxUpLeft);
            }
        }
        return dp[m][n];
    }
}