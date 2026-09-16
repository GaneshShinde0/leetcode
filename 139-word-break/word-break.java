class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);
        for(int i=0;i<n;i++){
            if(!dp[i]) continue;
            for(String word:set){
                int j = word.length();
                if(i+j<=n && s.substring(i,i+j).equals(word)) dp[i+j] = true;
            }
        }
        return dp[n];
    }
}