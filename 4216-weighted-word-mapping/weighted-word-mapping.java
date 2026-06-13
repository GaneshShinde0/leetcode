class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String word:words){
            int weight = 0;
            for(char c:word.toCharArray()){
                weight+=weights[c-'a'];
            }
            sb.append((char) (25-weight%26+'a'));
        }
        return sb.toString();
    }
}