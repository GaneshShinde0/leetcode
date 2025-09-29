class Solution {
    int[][] dp = new int[50][50];
    public int minScoreTriangulationRecursion(int[] values) {
        return minScoreTriangulation(values,0,0,0);
    }
    public int minScoreTriangulation(int[] values,int i, int j, int res) {
        if(j==0) j = values.length-1;
        if(dp[i][j]!=0) return dp[i][j];

        for(int k= i+1;k<j;k++){
            res = Math.min(res==0?Integer.MAX_VALUE:res,
                    minScoreTriangulation(values,i,k,0)+
                    values[i]*values[j]*values[k]+
                    minScoreTriangulation(values,k,j,0));
        }
        dp[i][j]=res;
        return dp[i][j];
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j],
                        dp[i][k] + values[i] * values[k] * values[j] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}