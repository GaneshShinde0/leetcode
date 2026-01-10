class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        
        // Fill Base Case Values
        // Deleting characcters from string 1 considering string 2 is empty.
        for(int i=1;i<=m;i++){
            dp[i][0] = dp[i-1][0]+ s1.charAt(i-1);
        }
        // Deleting characters from string 2 considering string 1 is empty.
        for(int i=1;i<=n;i++){
            dp[0][i] = dp[0][i-1]+ s2.charAt(i-1);
        }

        // Fill the remaining cells using the Bellman Equation.
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.min(s1.charAt(i)+dp[i][j+1],s2.charAt(j)+dp[i+1][j]);
                }
            }
        }

        // Return the answer for entire input strings
        return dp[m][n];
    }
}