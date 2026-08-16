class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(m>0 && n>0){
            char c1 = str1.charAt(m-1), c2 = str2.charAt(n-1);
            if(c1==c2){
                sb.append(c1);
                m--;
                n--;
            }else if(dp[m][n-1]>dp[m-1][n]){
                sb.append(c2);
                n--;
            }else{
                sb.append(c1);
                m--;
            }
        }
        while(m>0) sb.append(str1.charAt(--m));
        while(n>0) sb.append(str2.charAt(--n));
        return sb.reverse().toString();
    }
}