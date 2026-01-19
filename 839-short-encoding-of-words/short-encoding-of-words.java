class Solution {
    public int minimumLengthEncodingInitial(String[] words) {
        Arrays.sort(words,(a,b)->Integer.compare(b.length(),a.length()));
        StringBuilder sb = new StringBuilder();
        for(String word:words){
            if(sb.indexOf(word+"#")==-1){
                sb.append(word).append("#");
            }
        }
        return sb.length();
    }

    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        int totalLen=0;
        for(String word:words){
            set.add(word);
        }
        for(String word:words){
            int n = word.length();
            for(int i=1;i<n;i++){
                String sub = word.substring(i);
                if(set.contains(sub)){
                    set.remove(sub);
                }
            }
        }
        for(String word:set){
            totalLen+=word.length()+1;
        }
        // System.out.println(set);
        return totalLen;
    }
}