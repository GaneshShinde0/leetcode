class Solution {
    public int minimumPushesInitial(String word) {
        int[] freq = new int[26];
        for(char c:word.toCharArray()){
            freq[c-'a']++;
        }
        Arrays.sort(freq);
        int res = 0;
        for(int i=25;i>=0;i--){
            if(i>25-8) res+=freq[i];
            else if(i>25-16) res+=(2*freq[i]);
            else if(i>25-24) res+=(3*freq[i]);
            else res+=(4*freq[i]);
        }
        return res;
    }

    public int minimumPushes(String word) {
        if(word.length()<=8) return word.length();

        if(word.length()<=15) return 8 + word.length()%8*2;

        if(word.length()<=23) return 8 + 8*2 + word.length()%16*3;

        if(word.length()<=26) return 8 + 8*2 + 8*3+word.length()%24*4;

        return -1;
    }
}