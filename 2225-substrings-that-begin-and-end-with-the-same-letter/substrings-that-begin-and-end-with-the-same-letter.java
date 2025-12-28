class Solution {
    public long numberOfSubstrings(String s) {
        long res = s.length();
        long[] freq = new long[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        for(long i:freq){
            if(i>1) res +=(i*(i-1))/2;
        }
        return res;
    }
}