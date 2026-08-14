class MagicDictionary {
    HashMap<String,Integer> mapOfComb;
    Set<String> words;

    public MagicDictionary() {
        this.mapOfComb = new HashMap<>();
        this.words = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word:dictionary){
            int len = word.length();
            words.add(word);
            for(int i=0;i<len;i++){
                String comb = (word.substring(0,i)+"*"+word.substring(i+1));
                mapOfComb.put(comb, mapOfComb.getOrDefault(comb,0)+1);
            }
        }
    }
    
    public boolean search(String word) {
        int len = word.length();
        for(int i=0;i<len;i++){
            String comb = word.substring(0,i)+"*"+word.substring(i+1);
            if(words.contains(word)){
                if(mapOfComb.get(comb)>=2) return true;
            }
            else if(mapOfComb.containsKey(comb)) return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */