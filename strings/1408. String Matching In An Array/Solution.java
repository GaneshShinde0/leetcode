class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> li = new ArrayList();
        for(String word: words){
            for(String word1: words){
                if(!word.equals(word1) && !li.contains(word1) && word.contains(word1)){
                    li.add(word1);
                }
            }
        }
        return li;
    }
}
