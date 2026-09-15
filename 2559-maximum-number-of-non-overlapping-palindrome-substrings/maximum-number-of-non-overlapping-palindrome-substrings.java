class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] palindromeDP = new boolean[n + 1][n + 1];
        for (int end = 0; end < n; end++) {
            for(int start = 0;start<=end;start++){
                if(s.charAt(start)==s.charAt(end) && (end-start<=1 || palindromeDP[start+1][end-1])){
                    palindromeDP[start][end] = true;
                }
            }
        }
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            if(i>0) dp[i]=Math.max(dp[i-1],dp[i]);
            for(int j=i+k-1;j<n;j++){
                if(palindromeDP[i][j] && j-i+1>=k){
                    dp[j] = Math.max(dp[j], dp[Math.max(i-1,0)]+1);
                }
            }
        }
        return dp[n-1];
    }
}