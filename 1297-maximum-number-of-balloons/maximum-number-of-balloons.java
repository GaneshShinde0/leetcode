class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = getFreq(text);
        int[] bFreq = getFreq("balloon");
        int res = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(bFreq[i]>0){
                res = Math.min(res, freq[i]/bFreq[i]);
            }
        }
        return res;
    }
    private int[] getFreq(String text){
        int[] freq = new int[26];
        for(char c:text.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}