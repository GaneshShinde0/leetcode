class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(a,b)->Integer.compare(b.length(),a.length()));
        StringBuilder sb = new StringBuilder();
        for(String word:words){
            if(sb.indexOf(word+"#")==-1){
                sb.append(word).append("#");
            }
        }
        return sb.toString().length();
    }
}