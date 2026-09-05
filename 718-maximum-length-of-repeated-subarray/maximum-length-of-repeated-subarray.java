class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n =nums2.length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    dp[i+1][j+1]=1+dp[i][j];
                    res = Math.max(res, dp[i+1][j+1]);
                }
            }
        }
        return res;
    }
}