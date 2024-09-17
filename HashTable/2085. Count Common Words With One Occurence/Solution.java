class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        Set<String> combined = new HashSet<>();
        for(String str:words1) {
            map1.put(str,map1.getOrDefault(str,0)+1);
        }
        for(String str:words2){
            map2.put(str,map2.getOrDefault(str,0)+1);
        }
        int count =0;
        for(String word:words1){
            if(map1.get(word)==1 && map2.getOrDefault(word,0)==1){
                count++;
            }
        }
        return count;
    }
}
