class Solution {
    private static final int MOD = 1_000_000_007;
    public int countDistinctStringsInitial(String s, int k) {
        int n = s.length()-k+1;
        int ans = 1;
        while(n>0){
            ans = ans<<1;
            n--;
            ans%=MOD;
        }
        return ans;
    }

    public int countDistinctStrings(String s, int k) {
        int n = s.length()-k+1;
        int ans = 1;
        while(n>0){
            ans = ans<<1;
            n--;
            ans%=MOD;
        }
        return ans;
    }
}