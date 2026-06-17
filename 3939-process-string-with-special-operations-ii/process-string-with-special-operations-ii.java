/*
Simulation is Not possible because of 10^15 constraint.
- We can use StringBuilder and process elements in reverse order until we remove all special characters.

*/
class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        for(char c:s.toCharArray()){
            switch(c){
                case '*'->{if(len>0) len--;}
                case '#'-> len *=2;
                case '%'-> {}
                default-> len++;

            }
        }
        if(k+1>len) return '.';
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch(c){
                case '*'-> len++;
                case '#'->{
                    if(k+1>(len+1)/2){
                        k-=len/2;
                    }
                    len = (len+1)/2;
                }
                case '%'-> k = len-k-1;
                default ->{
                    if(k+1==len) return c;
                    len--;
                }
            }
        }
        return '.';
    }
}