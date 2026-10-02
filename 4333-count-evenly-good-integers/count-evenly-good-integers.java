class Solution {
    public long countEvenlyGoodIntegers(long l, long r) {
        return f(r)-f(l-1);
    }
    private long f(long n){
        if(n<=0) return 0;
        int pos = 0, digitLen = String.valueOf(n).length(), parity = 0;
        int[] arr = new int[digitLen];
        for(int i=0;i<digitLen;i++){
            arr[i] = (int) ((n/(pow(10,digitLen-i-1)))%10);
        }
        System.out.println(Arrays.toString(arr));
        long[][][] memo = new long[digitLen+1][2][2];
        for(long[][] me:memo){
            for(long[] m:me) Arrays.fill(m,-1l);
        }
        return helper(0, true, false, 0, arr, memo);
    }
    private long helper(int pos, boolean tight, boolean started, int parity, int[] digits, long[][][] memo){
        long count = 0;
        if(pos==digits.length){
           if(started && parity==0) return parity%2==0?1:0;
        }else if (!tight && memo[pos][started?1:0][parity] != -1) {
            return memo[pos][started?1:0][parity];
        }else{
            int limit = tight?digits[pos]:9;
            for(int d=0;d<=limit;d++){
                boolean newTight = tight && (d==limit);
                boolean newStarted = started || (d!=0);
                boolean toggle = newStarted && (d%2==0);
                int newParity = (parity+(toggle?1:0))%2;
                count+= helper(pos+1, newTight, newStarted, newParity, digits, memo);
            }
            if(!tight) memo[pos][started?1:0][parity] = count;
        }
        return count;
    }
    private long pow(int base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}