class GetLongestSubSequence {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for(int i =1; i<words.length;i++){
            if(groups[i]!=groups[i-1]){
                res.add(words[i]);
            }
        }
        return res;
    }
  public List<String> getLongestSubsequenceFaster(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        int prev = groups[0];
        for(int i=1;i<groups.length;i++){
            if(prev != groups[i]){
                ans.add(words[i]);
                prev = groups[i];
            }
        }
        return ans;
    }
}
