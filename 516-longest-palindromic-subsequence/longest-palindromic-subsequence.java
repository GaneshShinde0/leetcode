class Solution {
    public int longestPalindromeSubseqUsingReverse(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i+1][j+1]=1+dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[n][n];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i] = 1; // One character will always
        for(int i = 2;i<=n;i++){
            for(int l=0;l+i-1<n;l++){
                int r = l+i-1;
                if(s.charAt(l)==s.charAt(r)){
                    dp[l][r]= 2+ (l+1<=r-1?dp[l+1][r-1]:0);
                }else{
                    dp[l][r] = Math.max(dp[l+1][r], dp[l][r-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}