class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int temp =0;
        for(int i:freq){
            if(temp==0 && i!=0) temp =i;
            if (i!=0 && i!=temp) return false;
        }
        return true;
    }
}
