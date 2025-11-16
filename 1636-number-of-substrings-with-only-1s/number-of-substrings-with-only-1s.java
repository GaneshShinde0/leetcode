class Solution {
    private static final int MOD = 1000000007;
    public int numSub(String s) {
        int count = 0;
        int res = 0;
        for(char c:s.toCharArray()){
            if(c=='1'){count++;}
            else count = 0;
            res=(res+count)%MOD;
        }
        return res;
    }
}