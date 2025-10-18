class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int[] freq = new int[26];
        int[] idx = new int[26];
        int res = 0;
        int n = s.length();
        int lastRepeated = -1;
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
            if(i>=k){
                freq[s.charAt(i-k)-'a']--;
            }
            if(freq[s.charAt(i)-'a']>1) lastRepeated = Math.max(idx[s.charAt(i)-'a'],lastRepeated);
            if((i-lastRepeated)>=k){
                res++;
            }
            idx[s.charAt(i)-'a']=i;
        }
        return res;
    }
}