class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int res = n;
        int word1Idx=Integer.MAX_VALUE, word2Idx=Integer.MAX_VALUE-n;
        for(int i=0;i<n;i++){
            if(wordsDict[i].equals(word1)){
                word1Idx=i;
            }else if(wordsDict[i].equals(word2)){
                word2Idx=i;
            }
            res = Math.min(Math.abs(word1Idx-word2Idx),res);
        }  
        return res;
    }
}