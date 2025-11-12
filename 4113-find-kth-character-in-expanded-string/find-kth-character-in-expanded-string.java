class Solution {
    public char kthCharacter(String s, long k) {
        int counter = 0;
        int i=0;
        for(;i<s.length();i++){
            if(s.charAt(i)==' ') counter=0;
            counter++;
            k-=counter;
            if(s.charAt(i)==' ') counter=0;
            if(k<0) break;
        }
        return s.charAt(i);
    }
}