class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];

        // Prefix sum to get sum(i,j) in O(1)
        int[] prefix = new int[n+1];
        for(int i=1;i<=n;i++){
            prefix[i]= prefix[i-1]+stones[i-1];
        }

        // Len = Length of the subarray we're considering
        for(int len = 2; len<=n; len++){
            for(int i =0; i+len<=n;i++){
                int j = i+len-1;
                int sumLeft = prefix[j+1]-prefix[i+1]; // Remove i
                int sumRight = prefix[j]-prefix[i];
                dp[i][j] = Math.max(sumLeft - dp[i+1][j],sumRight - dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}