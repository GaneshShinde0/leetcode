class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        s = s.toLowerCase();
        while(start<end){
            while(start<end && ((s.charAt(start)<'0' || s.charAt(start)>'9') && (s.charAt(start)>'z' || s.charAt(start)<'a'))){
                start++;
            }
            while(start<end && ((s.charAt(end)<'0' || s.charAt(end)>'9') && (s.charAt(end)>'z' || s.charAt(end)<'a'))){
                end--;
            }
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}