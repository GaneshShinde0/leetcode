class Solution {
    public boolean doesAliceWin20ms(String s) {
        int vowelCount = 0;
        for(char c: s.toCharArray()){
            if(s.indexOf(c)>=0) vowelCount++;
        }
        if(vowelCount==0) return false;
        return true;
    }
    
    public boolean doesAliceWin5ms(String s) {
        int vowelCount = 0;
        for(char c: "aeiou".toCharArray()){
            if(s.indexOf(c)>=0) vowelCount++;
        }
        if(vowelCount==0) return false;
        return true;
    }

    public boolean doesAliceWin(String s) {
        for(char c: "aeiou".toCharArray()){
            if(s.indexOf(c)>=0) return true;
        }
        return false;
    }
}