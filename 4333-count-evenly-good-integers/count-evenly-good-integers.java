class Solution {
    public long countEvenlyGoodIntegers(long l, long r) {
        return countTillN(r)-countTillN(l-1);
    }
    private long countTillN(long n){
        String s = String.valueOf(n);
        long[][][] dp = new long[s.length()][2][2];
        for(long[][] di:dp){
            for(long[] d:di) Arrays.fill(d,-1);
        }
        return f(dp,s, 0, false, true);
    }
    private long f(long[][][] dp, String s, int idx, boolean smaller, boolean parity){
        if(idx == s.length()){
            if(parity) return 1;
            return 0;
        }else if(dp[idx][smaller?0:1][parity?0:1]!=-1){
            return dp[idx][smaller?0:1][parity?0:1];
        }else{
            int limit = smaller?9:(s.charAt(idx)-'0');
            long count = 0;
            for(int d=0;d<=limit;d++){
                boolean newSmaller = smaller||(s.charAt(idx)-'0')>d;
                boolean newParity = parity==(d%2==1);
                count+=f(dp,s,idx+1,newSmaller, newParity);
            }
            dp[idx][smaller?0:1][parity?0:1] = count;
        }
        return dp[idx][smaller?0:1][parity?0:1];
    }
}