class Solution {
    private static final int MOD = 1000000007;
    public int countHomogenous(String s) {
        int count =1 ;
        int res = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)!=s.charAt(i)){
                count=1;
            }else{
                count++;
            }
            res = (res+count)%MOD;
        }
        return res;
    }
}