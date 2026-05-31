class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char single = '#';
        for(int i=0;i<26;i++){
            char ch = (char) (i+'a');
            if(freq[i]%2==1){
                single = ch;
            }
            sb.append((ch+"").repeat(freq[i]/2));
        }
        String orig = sb.toString();
        String rev = sb.reverse().toString();
        if(single!='#'){
            return orig + single+rev;
        }else{
            return orig+rev;
        }
    }
}