class WordDistance {

    private HashMap<String, List<Integer>> hm = new HashMap<>();
    public WordDistance(String[] wordsDict) {
        for(int i=0;i<wordsDict.length;i++){
            hm.computeIfAbsent(wordsDict[i],k->new ArrayList<>()).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = hm.get(word1);
        List<Integer> l2 = hm.get(word2);
        int res = Integer.MAX_VALUE;
        for(int i:l1){
            for(int j:l2){
                res = Math.min(Math.abs(i-j),res);
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */