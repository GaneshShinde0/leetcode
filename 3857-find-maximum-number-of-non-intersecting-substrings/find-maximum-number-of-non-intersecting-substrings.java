class Solution {
    public int maxSubstrings(String word) {
        int res = 0;
        Map<Character,Integer> pos = new HashMap<>();
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!pos.containsKey(c)){
                pos.put(c,i);
            }else if (i-pos.get(c)+1>=4){
                res++;
                pos.clear();
            }
        }
        return res;
    }
}