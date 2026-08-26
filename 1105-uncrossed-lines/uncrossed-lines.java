/*
0 1 1
0 1 1

Lets see how much each point has to travel forward to get match.

Input: 
nums1 = [2,5,1,2,5], 
nums2 = [10,5,2,1,5,2]

2 4 
*/

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] dp = new int[n+1];
        for (int i = 0; i < m; i++) {
            int prev = 0;
            for (int j = 0; j < n; j++) {
                int temp = dp[j+1];
                if(nums1[i]==nums2[j]){
                    dp[j+1] = prev+1;
                }else{
                    dp[j+1] = Math.max(temp,dp[j]);
                }
                prev = temp;
            }
        }
        return dp[n];
    }
    public int maxUncrossedLinesDP(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums1[i]==nums2[j]){
                    dp[i+1][j+1] = 1+dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[m][n];
    }
}