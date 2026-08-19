class Solution {
    public int appendCharacters(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int sPtr = 0, tPtr = 0;
        while(sPtr<sLen&&tPtr<tLen){
            if(s.charAt(sPtr)==t.charAt(tPtr)) tPtr++;
            sPtr++;
        }
        return tLen-tPtr;
    }
}