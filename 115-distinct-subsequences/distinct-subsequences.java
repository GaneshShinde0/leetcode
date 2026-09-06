class Solution {
    public int numDistinct(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int[][] dp = new int[sLen+1][tLen+1];
        for(int i=0;i<=sLen;i++){
            dp[i][0] = 1;
        }
        for(int j=0;j<tLen;j++){
            for(int i=0;i<sLen;i++){
                if(s.charAt(i)==t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j+1]+dp[i][j];
                }else{
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }
        return dp[sLen][tLen];
    }
}