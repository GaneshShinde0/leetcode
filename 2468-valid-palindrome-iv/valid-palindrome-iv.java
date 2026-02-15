class Solution {
    public boolean makePalindrome(String s) {
        int mismatch = 0, n= s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                mismatch++;
            }
            if(mismatch==3) return false;
        }
        return true;
    }
}