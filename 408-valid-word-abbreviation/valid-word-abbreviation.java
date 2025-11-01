class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        int n = word.length(), m = abbr.length();

        while (i < n && j < m) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') return false; // leading zero
                int num = 0;
                while (j < m && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num; // skip num letters
            } else {
                if (i >= n || word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            }
        }

        return i == n && j == m;
    }
    public boolean validWordAbbreviationInitial(String word, String abbr) {
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