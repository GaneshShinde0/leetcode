import java.math.BigInteger;
class SolutionInitial{
    private static final int MOD = 1000000007;
        private static final BigInteger BMOD = new BigInteger("1000000007");

    public int[] sumAndMultiply(String s, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            res[i] = sumAndMultiply(s,queries[i][0],queries[i][1]);
        }
        return res;
    }

    public int sumAndMultiply(String s, int i, int j) {
        int num = 0;
        int sumOfDig = 0;
        StringBuilder sb = new StringBuilder();
        while(i<=j){
            if(s.charAt(i)!='0'){
                sumOfDig+=(s.charAt(i)-'0');
                sb.append(s.charAt(i));
            }
            i++;
        }
        if(sb.length()==0) return 0;
        return (((new BigInteger(sb.toString()).mod(BMOD).multiply(new BigInteger(sumOfDig+"")))).mod(BMOD)).intValue();
    }
}

class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] prefixSum = new int[n + 1];      // sum of non-zero digits
        int[] prefixNum = new int[n + 1];      // number formed by concatenating non-zero digits up to i-1 (mod MOD)
        int[] prefCnt = new int[n + 1];        // count of non-zero digits up to i-1
        int[] pow10 = new int[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) pow10[i] = (int)((pow10[i - 1] * 10L) % MOD);

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            prefixSum[i + 1] = prefixSum[i];
            prefixNum[i + 1] = prefixNum[i];
            prefCnt[i + 1] = prefCnt[i];
            if (d != 0) {
                prefixSum[i + 1] = prefixSum[i] + d;
                prefixNum[i + 1] = (int)((prefixNum[i] * 10L + d) % MOD);
                prefCnt[i + 1] = prefCnt[i] + 1;
            }
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int qi = 0; qi < m; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];

            int sumOfDigits = prefixSum[r + 1] - prefixSum[l];
            if (sumOfDigits == 0) {
                res[qi] = 0;
                continue;
            }

            int cntNonZero = prefCnt[r + 1] - prefCnt[l];
            if (cntNonZero == 0) { // redundant due to sumOfDigits check, but safe
                res[qi] = 0;
                continue;
            }

            int totalPart = prefixNum[r + 1];
            int leftPart = prefixNum[l];
            int power = pow10[cntNonZero];

            long num = (totalPart - (leftPart * 1L * power) % MOD);
            if (num < 0) num += MOD;

            long ans = (num * (long) sumOfDigits) % MOD;
            res[qi] = (int) ans;
        }

        return res;
    }
}
