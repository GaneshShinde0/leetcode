class Solution {
    public int uniquePathsInitialDoesNotWork(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0]=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i-1>0){
                    dp[i][j]+=dp[i-1][j]+1;
                }
                if(j-1>0){
                    dp[i][j]+=dp[i][j-1]+1;
                }
            }
        }
        if(m>1) dp[m-1][n-1]++;
        if(n>1) dp[m-1][n-1]++;
        return dp[m-1][n-1];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}