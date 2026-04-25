class Solution1 {
    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character, String> symbolMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        return backtrack(pattern,0,s,0,symbolMap,wordSet);
    }
    private boolean backtrack(String pattern, int pIdx, String s, int sIdx, HashMap<Character, String> symbolMap, Set<String> wordSet){
        if(pIdx == pattern.length()){
            return (sIdx == s.length());
        }
        if(symbolMap.containsKey(pattern.charAt(pIdx))){
            String word = symbolMap.get(pattern.charAt(pIdx));
            String substr = s.substring(sIdx);
            if(!substr.startsWith(word)) return false;
            return backtrack(pattern, pIdx+1, s, sIdx+word.length(), symbolMap, wordSet );
        }
        for(int i=sIdx;i<s.length();i++){
            String substr = s.substring(sIdx,i+1);
            if(wordSet.contains(substr)) continue;
            wordSet.add(substr);
            symbolMap.put(pattern.charAt(pIdx), substr);
            if(backtrack(pattern, pIdx+1, s, i+1, symbolMap, wordSet)) return true;
            wordSet.remove(substr);
            symbolMap.remove(pattern.charAt(pIdx));
        }
        return false;
    }

}

class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        String[] symbols = new String[26];
        Arrays.fill(symbols, "");
        Set<String> wordSet = new HashSet<>();
        return backtrack(pattern, 0, s,0, symbols, wordSet);
    }
    private boolean backtrack(String pattern, int pIdx, String s, int sIdx, String[] symbols, Set<String> wordSet){
        if(pIdx == pattern.length()){
            return (sIdx == s.length());
        }
        char symbol = pattern.charAt(pIdx);
        if(!symbols[symbol-'a'].equals("")){
            String word = symbols[symbol-'a'];
            if(!s.startsWith(word, sIdx)){
                return false;
            }
            // If it matches continue to match the rest
            return backtrack(pattern,pIdx+1,s,sIdx+word.length(), symbols, wordSet);
        }
        int filledSpots=0;
        for(int i=pIdx+1;i<pattern.length();i++){
            char p = pattern.charAt(i);
            filledSpots += symbols[p-'a'].equals("")?1:symbols[p-'a'].length();
        }
        for(int k = sIdx+1; k<=s.length()-filledSpots; k++){
            String substr = s.substring(sIdx, k);
            if(wordSet.contains(substr)) continue;
            symbols[symbol-'a'] = substr;
            wordSet.add(substr);
            if(backtrack(pattern,pIdx+1,s,k,symbols, wordSet)) return true;
            symbols[symbol-'a']="";
            wordSet.remove(substr);
        }
        return false;
    }

}