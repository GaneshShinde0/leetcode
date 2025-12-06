class Solution {
    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[][] dp = new int[slen+1][tlen+1];
        dp[0][0] = 1;
        //(non-empty string cannot be subsequence of empty)
        for (int i = 0; i <= slen; i++) {
            dp[i][0] = 1;
        }
        for(int i=0;i<slen;i++){
            for(int j=0;j<tlen;j++){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j+1]+dp[i][j];
                }else{
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[slen][tlen];
    }
}