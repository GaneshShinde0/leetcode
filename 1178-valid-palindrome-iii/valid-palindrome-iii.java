class Solution {
    public boolean isValidPalindrome(String s, int k) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(s.charAt(i)==rev.charAt(j)){
                    dp[i+1][j+1] = 1+dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return (n-dp[n][n])<=k;
    }
}