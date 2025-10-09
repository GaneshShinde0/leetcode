class Solution {
    public int countOddLetters(int n) {
        int[] freq = new int[26];
        String[] letterRep = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        StringBuilder sb = new StringBuilder();

        while(n>0){
            sb.append(letterRep[n%10]);
            n=n/10;
        }
        for(char c:sb.toString().toCharArray()){
            freq[c-'a']++;
        }
        int res = 0;
        for(int i:freq){
            if(i%2==1) res++;
        }
        return res;
    }
}