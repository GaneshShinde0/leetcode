class Solution {
    private static final int MOD = 1_000_000_007;
    public int monkeyMove(int n) {
        long res = 1, base = 2;
        while(n>0){
            if(n%2==1) res = res*base%MOD;
            base = base*base%MOD;
            n>>=1;
        }
        return (int)((res - 2 + MOD ) % MOD);
    }
}