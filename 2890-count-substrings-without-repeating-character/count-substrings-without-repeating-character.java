class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int lastDouble = -1;
        int curr = 1;
        int[] lastIdx = new int[26];
        int res = 0;
        Arrays.fill(lastIdx,-1);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(lastIdx[c-'a']>lastDouble){
                curr = i-lastIdx[c-'a'];
                lastDouble=lastIdx[c-'a'];
            }
            lastIdx[c-'a']=i;
            res+=curr;
            curr++;
        }
        return res;
    }
}