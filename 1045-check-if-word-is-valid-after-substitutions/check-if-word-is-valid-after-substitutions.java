class Solution {
    public boolean isValid(String s) {
        int n = s.length()/3;
        while(n>0){
            s = s.replace("abc","");
            n--;
        }
        return s.equals("");
    }
}