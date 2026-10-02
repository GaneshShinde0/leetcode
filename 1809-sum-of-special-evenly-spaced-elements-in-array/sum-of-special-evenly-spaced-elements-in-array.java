class Solution {
    public int[] solve(int[] nums, int[][] queries) {
        final int mod = 1_000_000_007; 
        int n = nums.length, r = (int) Math.sqrt(n); 
        long[][] dp = new long[n][r]; 
        for (int i = n-1; i >= 0; --i) 
            for (int j = 0; j < r; ++j) {
                dp[i][j] = nums[i]; 
                if (i+j < n) dp[i][j] = (dp[i][j] + dp[i+j][j]) % mod; 
            }
        int[] ans = new int[queries.length]; 
        for (int i = 0; i < queries.length; ++i) {
            int x = queries[i][0], y = queries[i][1]; 
            if (y < r) ans[i] = (int) dp[x][y]; 
            else {
                long val = 0; 
                for (int j = x; j < n; j += y) val = (val + nums[j]) % mod; 
                ans[i] = (int) val; 
            }
        }
        return ans; 
    }
}