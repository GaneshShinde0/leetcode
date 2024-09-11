class Solution {
    public char repeatedCharacter(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
            if(freq[c-'a']==2) return c;
        }
        return s.charAt(0);
    }
}
