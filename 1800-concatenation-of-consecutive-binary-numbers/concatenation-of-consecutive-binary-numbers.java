class Solution {
    public int concatenatedBinaryInitial(int n) {
        final int MOD = 1000000007;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            for (int j = 0; j < binary.length(); j++) {
                result = (result * 2 + (binary.charAt(j) - '0')) % MOD;
            }
        }
        return result;
    }


    public int concatenatedBinary(int n){
        final int MOD = 1000000007;
        int length = 0;
        long result = 0;

        for(int i=1;i<=n;i++){
            if((i&(i-1)) ==0) length++; // When meets power of two increase length bit.
            result = (result<<length | i  )%MOD;
        }
        return (int)result;
    }
}