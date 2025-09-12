class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1]; // dp[i] means string until ith index can be made using wordDict;
        dp[0]=true; // There will always be string with length 0;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && words.contains(s.substring(j,i))){
                    dp[i] = true; // We are basically telling that some combinations of word matches s until i;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}