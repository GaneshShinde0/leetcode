class Solution {
    public int waysToDistribute(int n, int k) {
        int M = (int)1e9+7;
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < k; i++){
            long[] next = new long[n];
            for (int j = 1; j < n; j++){
                next[j]=((i+1)*next[j-1]+dp[j-1])%M;
            }
            dp=next;
        }
        return (int)dp[n-1];
    }
}