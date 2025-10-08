class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean singleOdd = false;
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        for(int i=0;i<26;i++){
            if(freq[i]%2==1 && singleOdd){
                return false;
            }
            if(freq[i]%2==1){
                singleOdd=true;
            }
        }
        return true;
    }
}