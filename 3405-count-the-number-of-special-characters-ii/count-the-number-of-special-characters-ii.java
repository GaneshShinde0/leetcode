class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastIdx = new int[128];
        Arrays.fill(lastIdx,-1);
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(c>='a' && c<='z'){
                lastIdx[c]=i;
            }else if(c>='A' && c<='Z'){
                if(lastIdx[c]==-1) lastIdx[c]=i;
            }
        }
        int res = 0;
        for(int i='A';i<='Z';i++){
            if(lastIdx[i+32]>=0 && lastIdx[i]>lastIdx[i+32]) res++;
        }
        return res;
    }
}