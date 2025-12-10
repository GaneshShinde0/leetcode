class Solution {
    Map<String, List<String>> memo = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, dict);
    }
    
    private List<String> dfs(String s, Set<String> dict) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> result = new ArrayList<>();
        
        if (dict.contains(s))
            result.add(s); // whole word

        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                List<String> suffixWays = dfs(s.substring(i), dict);
                for (String suffix : suffixWays) {
                    result.add(prefix + " " + suffix);
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }

    Set<String> words;
    public List<String> wordBreakInitial(String s, List<String> wordDict) {
        words  = new HashSet<>(wordDict);
        return wordBreak(s,wordDict, new ArrayList<StringBuilder>());
    }
    public List<String> wordBreak(String s, List<String> wordDict,List<StringBuilder> res) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(words.contains(sb.toString())){
                res.add(new StringBuilder(sb).append(" "));
                List<String> sub = wordBreak(s.substring(i+1),wordDict,new ArrayList<StringBuilder>());
                int size = res.size();
                for(int j=0;j<size;j++){
                    for(String t:sub){
                        StringBuilder sb1 = res.get(j);
                        if(sb1.charAt(sb1.length()-1)!='#') 
                        res.add(new StringBuilder(sb1).append(t).append("#"));
                    }
                }
            }
        }
        int n = s.length();
        List<String> list = new ArrayList<>();
        for(StringBuilder sb1: res){
            sb1.deleteCharAt(sb1.length()-1);
            int count = 0;
            String str = sb1.toString();
            for(char c:str.toCharArray()){
                if(c!=' ') count++;
            }
            if(count == n) list.add(str);
        }
        return list;
    }
}