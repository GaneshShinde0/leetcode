class Solution {
    int[][] dp;
    int MOD = 1_000_000_007;
    public int numberOfWays(int startPos, int endPos, int k) {
        this.dp = new int[1001][1001];
        return dfs(k, Math.abs(startPos-endPos));
    }
    private int dfs(int k, int d){
        if(d>=k) return d==k?1:0;
        if(dp[k][d]==0){
            dp[k][d] = (1+dfs(k-1,d+1)+dfs(k-1,Math.abs(d-1)))%MOD;
        }
        return dp[k][d]-1;
    }
}