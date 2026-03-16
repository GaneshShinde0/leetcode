class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        HashMap<String,Integer> map = new HashMap<>();
        for(String word:words) map.put(word,1);
        for(String word:words){
            int longest = 1;
            String current = "";
            for(int i=0;i<word.length();i++){
                current = word.substring(0,i)+word.substring(i+1);
                if(map.containsKey(current)) longest = Math.max(longest,map.get(current)+1);
            }
            map.put(word,longest);
        }
        return map.values().stream().max(Integer::compare).get();
    }
}