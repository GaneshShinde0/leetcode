class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int lastDouble = -1;
        int curr = 1;
        int[] freq = new int[26];
        int res = 0;
        Arrays.fill(freq,-1);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(freq[c-'a']>lastDouble){
                curr = i-freq[c-'a'];
                lastDouble=freq[c-'a'];
            }
            freq[c-'a']=i;
            res+=curr;
            curr++;
        }
        return res;
    }
}