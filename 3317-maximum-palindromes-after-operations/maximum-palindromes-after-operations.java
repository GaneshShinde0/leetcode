class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] freq = new int[26];
        List<Integer> li = new ArrayList<>();
        for(String s:words){
            for(char c:s.toCharArray()){
                freq[c-'a']++;
            }
            li.add(s.length());
        }
        Collections.sort(li);
        int res = 0, pairs = 0;
        for(int f:freq){
            pairs+=f/2;
        }
        for(int curr:li){
            pairs -= curr/2;
            if(pairs<0) return res;
            res++;
        }
        return res;
    }
    
}