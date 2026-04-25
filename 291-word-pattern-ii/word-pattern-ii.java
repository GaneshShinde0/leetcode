class Solution {
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