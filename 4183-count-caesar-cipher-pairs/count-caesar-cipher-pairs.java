class Solution {
    public long countPairs(String[] words) {
        Map<String,Long> hm = new HashMap<>();
        // Have to normalize all words wrt to minimum.
        for(String word:words){
            int diff = word.charAt(0)-'a';
            StringBuilder sb = new StringBuilder();
            for(char c:word.toCharArray()){
                char temp = (char) ('a'+((c-'a')-diff+26)%26);
                sb.append(temp);
            }
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0l)+1);
        }
        long res = 0;
        for(Map.Entry<String, Long> entry: hm.entrySet()){
            long temp = entry.getValue();
            if(temp>0){
                res+=(temp*(temp-1))/2;
            }
        }
        return res;
    }
}