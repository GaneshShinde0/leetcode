class Solution {
    public String betterCompression(String compressed) {
        int[] freq = new int[26];
        int i=1, n = compressed.length();
        char prevC = compressed.charAt(0);
        int currFreq = 0;
        while(i<n){
            char c = compressed.charAt(i);
            if(Character.isDigit(c)){
                currFreq = currFreq*10+(c-'0');
            }else{
                freq[prevC-'a']+=currFreq;
                currFreq = 0;
                prevC = c;
            }
            i++;
        }
        freq[prevC-'a']+=currFreq;
        StringBuilder sb = new StringBuilder();
        for(i=0;i<26;i++){
            if(freq[i]>0){
                sb.append((char)(i+'a'));
                sb.append(freq[i]);
            }
        }
        return sb.toString();
    }
}