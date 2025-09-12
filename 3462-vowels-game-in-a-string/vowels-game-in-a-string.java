class Solution {
    public boolean doesAliceWin(String s) {
        String vowels = "aeiou";
        int vowelsCount = 0, n = s.length();
        for(char c:s.toCharArray()){
            if(vowels.indexOf(c)>=0) vowelsCount++;
        }
        if(vowelsCount==0) return false;
        else return true;
    }
}