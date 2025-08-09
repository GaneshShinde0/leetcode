class Solution {
    public String getHint(String secret, String guess) {
        int[] freqS = new int[10];
        int[] freqG = new int[10];
        int a=0;
        int[] freqSet = new int[10];
        for(int i=0; i<secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s==g){
                a++;
                freqSet[s-'0']++;
            }
            freqS[s-'0']++;
            freqG[g-'0']++;
        }
        int b= 0;
        for(int i=0;i<10;i++){
            if(freqS[i]<=freqG[i]){
                b+=freqS[i]-freqSet[i];
            }else {
                b+=freqG[i]-freqSet[i];
            }
        }
        return a+"A"+b+"B";
    }
}