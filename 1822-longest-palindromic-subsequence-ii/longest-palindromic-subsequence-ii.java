class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][][] dp = new int[s.length()][s.length()][26];
        int max = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i-1;j>=0;j--){
                if(j == i-1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[j][i][s.charAt(i)-'a'] = 2;
                        max = Math.max(max, 2);
                    }
                } else {
                    for(int k=0;k<26;k++){
                        if(s.charAt(i) == s.charAt(j) && s.charAt(i) - 'a' != k){
                            dp[j][i][s.charAt(i)-'a'] = Math.max(dp[j+1][i-1][k] + 2, dp[j][i][s.charAt(i)-'a']);
                            max = Math.max(max, dp[j][i][s.charAt(i)-'a']);
                        }
                        dp[j][i][k] = Math.max(dp[j][i][k], dp[j][i-1][k]);
                        dp[j][i][k] = Math.max(dp[j][i][k], dp[j+1][i][k]);
                        dp[j][i][k] = Math.max(dp[j][i][k], dp[j+1][i-1][k]);
                    }
                }
            }
        }
        return max;
    }
}