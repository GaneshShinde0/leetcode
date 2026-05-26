class Solution {
    public int numberOfSpecialChars(String word) {
        int res = 0;
        int[] freq = new int[128];
        for(char c :word.toCharArray()){
            freq[c]++;
        }
        for(int i=0;i<97;i++){
            if(freq[i]>0 && freq[i+32]>0) res++;
        }
        return res;
    }
}