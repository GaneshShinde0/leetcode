class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length()>t.length()) return isOneEditDistance(t,s);
        if(s.equals(t)||Math.abs(s.length()-t.length())>1) return false;
        int j = 0, i=0;
        int ops = 0;
        for(;i<s.length()&&j<t.length();i++){
            if(s.charAt(i)==t.charAt(j)){
                j++;
            }else {
                if(s.length()==t.length()){
                    j++;
                    ops++;
                }else{
                    j++;
                    i--;
                    ops++;
                }
            }
        }
        return ops<=1;
    }
}