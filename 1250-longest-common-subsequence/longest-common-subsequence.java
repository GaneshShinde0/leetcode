class Solution {
    // Bottom Up Approach
    public int longestCommonSubsequenceBottomUp(String text1, String text2) {
        int m = text1.length(), n=text2.length();
        int[][] dp = new int[m+1][n+1];
        // if(m<n) return longestCommonSubsequence(text2,text1);
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }









    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1] = 1+dp[i][j];
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[l1][l2];
    }


}