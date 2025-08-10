class Solution {
    public int minSteps(String s, String t) {
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        int distA=0, distB=0;
        for(char c:s.toCharArray()){
            freqS[c-'a']++;
        }
        for(char c:t.toCharArray()){
            freqT[c-'a']++;
        }
        int res = 0;
        for(int i=0;i<26;i++){
            res+=Math.abs(freqS[i]-freqT[i]);
        }
        return res;
    }
}