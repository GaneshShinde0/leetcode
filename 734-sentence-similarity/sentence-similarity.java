class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length!=sentence2.length) return false;
        HashMap<String,Set<String>> similar = new HashMap<>();
        for(List<String> pair:similarPairs){
            similar.computeIfAbsent(pair.get(0),k->new HashSet<String>()).add(pair.get(1));
            similar.computeIfAbsent(pair.get(1),k->new HashSet<String>()).add(pair.get(0));
        }
        for(int i=0;i<sentence1.length;i++){
            if(sentence1[i].equals(sentence2[i])) continue;
            if((similar.containsKey(sentence1[i]) && similar.get(sentence1[i]).contains(sentence2[i]))) continue;
            // if(similar.containsKey(sentence2[i]) && similar.get(sentence2[i]).contains(sentence1[i])) continue;
            return false;
        }
        return true;
    }
}