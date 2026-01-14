class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int pPtr = 0, sPtr = 0;
        int starPtr = -1;
        int match = 0; // Index in s that was covered when we found the *.
        while(sPtr<sLen){
            // If one character matches increment both.
            if(pPtr < pLen &&(s.charAt(sPtr)==p.charAt(pPtr)||p.charAt(pPtr)=='?')){
                sPtr++;
                pPtr++;
            }else if(pPtr < pLen && p.charAt(pPtr)=='*'){
                starPtr = pPtr;
                match = sPtr;
                pPtr++;
            }else if(starPtr!=-1){
                pPtr = starPtr+1;
                match++;
                sPtr=match;
            }else{
                return false;
            }
        }
        while(pPtr<pLen && p.charAt(pPtr)=='*'){
            pPtr++;
        }
        return pPtr==pLen;
    }
}