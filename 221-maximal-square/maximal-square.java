class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[][] dp =new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    if(i==0 || j==0)dp[i+1][j+1] = 1;
                    else dp[i+1][j+1]= Math.min(Math.min(dp[i][j],dp[i+1][j]),dp[i][j+1])+1;
                    res = Math.max(dp[i+1][j+1],res);
                }
            }
        }
        return res*res;
    }
}