public class Solution {
    private int dfs(int[] v, int[] q, int x, int y, int[][] dp) {
        if (dp[x][y] >= 0) return dp[x][y];
        
        int t1 = (x > 0) ? dfs(v, q, x - 1, y, dp) : -1;
        int t2 = (y < v.length) ? dfs(v, q, x, y + 1, dp) : -1;
        
        dp[x][y] = Math.max(Math.max(t1, t2), 0);
        
        if (t1 >= 0 && t1 < q.length && v[x - 1] >= q[t1]) {
            dp[x][y] = Math.max(dp[x][y], t1 + 1);
        }
        
        if (t2 >= 0 && t2 < q.length && v[y] >= q[t2]) {
            dp[x][y] = Math.max(dp[x][y], t2 + 1);
        }
        
        return dp[x][y];
    }

    public int maximumProcessableQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][n] = 0;
        
        int result = 0;
        
        for (int i = 0; i < n; ++i) {
            result = Math.max(result, dfs(nums, queries, i, i, dp));
        }
        
        return result;
    }
}