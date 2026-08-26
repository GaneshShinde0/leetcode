/*

*/

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        // dp[j] represents the LCS length using the current row of nums1
        // processed so far, against the first j elements of nums2.
        // Initially (before processing any nums1 element), all values are 0.
        int[] dp = new int[n + 1];

        for (int i = 0; i < m; i++) {
            // 'prev' tracks the "diagonal" value dp[i][j] from the PREVIOUS row,
            // i.e., the LCS length using nums1[0..i-1] and nums2[0..j-1].
            // At j = 0, this is dp[i][0], which is always 0.
            int prev = 0;

            for (int j = 0; j < n; j++) {
                // Before overwriting dp[j+1], save its old value.
                // This old value is dp[i][j+1] (previous row, column j+1) —
                // it becomes the diagonal value needed for the NEXT iteration.
                int temp = dp[j + 1];

                if (nums1[i] == nums2[j]) {
                    // Match found: extend the LCS using the diagonal value
                    // dp[i][j] (stored in 'prev'), then add 1 for this match.
                    dp[j + 1] = prev + 1;
                } else {
                    // No match: take the best of
                    //   - dp[i][j+1]  -> old value, saved in 'temp'
                    //   - dp[i+1][j]  -> current row's value at column j,
                    //                    already updated (dp[j] as-is)
                    dp[j + 1] = Math.max(temp, dp[j]);
                }

                // Update 'prev' for the next column: it should now hold
                // dp[i][j+1], which we saved in 'temp' before this iteration.
                prev = temp;
            }
        }

        // dp[n] now holds the LCS length using all of nums1 and all of nums2.
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