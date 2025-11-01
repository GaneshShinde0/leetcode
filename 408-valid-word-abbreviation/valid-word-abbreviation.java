class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int j = 0;
        int m = abbr.length();
        int curr = 0;
        for(int i=0;i<abbr.length();i++){
            if(i<m && Character.isDigit(abbr.charAt(i))){
                curr=curr*10+(abbr.charAt(i)-'0');
                if(curr==0||(curr+(i-numberOfDigits(curr))>=word.length())) return false;
                continue;
            }
            j+=curr;
            curr = 0;
            if(j<word.length() && i<m && word.charAt(j)!=abbr.charAt(i)){
                return false;
            }
            if(j>=word.length()) return false;
            if(word.charAt(j)==abbr.charAt(i)) j++;
        }
        if((j+curr)!=word.length()) return false;
        return true;
    }
    private int numberOfDigits(int n){
        int res = 0;
        while(n>0){
            n=n/10;
            res++;
        }
        return res;
    }
}