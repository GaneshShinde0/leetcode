class Solution {
    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[][] dp = new int[slen+1][tlen+1];
        dp[0][0] = 1; // At begining empty string can match with empty string.
        for (int i = 0; i <= slen; i++) {
            dp[i][0] = 1; //base: empty target can always be formed exactly 1 way
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