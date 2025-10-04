class Solution {
    public int minDistanceBruteForceRecursion(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return f(n-1,m-1,word1,word2);
    }

    private int f(int i, int j, String s1, String s2){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(s1.charAt(i)==s2.charAt(j)) return f(i-1,j-1,s1,s2);
        return 1+Math.min(f(i-1,j,s1,s2),Math.min(f(i,j-1,s1,s2),f(i-1,j-1,s1,s2)));
    }

    
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];
        for(int[] arr:dp) Arrays.fill(arr,Integer.MAX_VALUE);
        
        for(int i=0;i<m+1;i++){
            dp[i][n]=m-i;
        }
        for(int j=0;j<n+1;j++){
            dp[m][j]= n-j;
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1];
                }else{
                    dp[i][j] = 1+Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}