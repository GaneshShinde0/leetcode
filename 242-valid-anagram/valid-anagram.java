class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq1 = getFreq(s);
        int[] freq2 = getFreq(t);
        return Arrays.equals(freq1,freq2);
    }
    private int[] getFreq(String s){
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}