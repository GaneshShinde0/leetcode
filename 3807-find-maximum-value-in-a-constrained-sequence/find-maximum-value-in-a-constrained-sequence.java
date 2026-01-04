class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int[] r:restrictions){
            dp[r[0]]=r[1];
        }
        for(int i=1;i<n;i++){
            dp[i]= Math.min(dp[i],dp[i-1]+diff[i-1]); // diff[i-1] == Abs(dp[i]-dp[i-1]; ... so dp[i] naturally becomes => diff[i-1]+dp[i-1];
        }

        for(int i=n-2;i>=0;i--){
            dp[i]=Math.min(dp[i],dp[i+1]+diff[i]);
        }
        int res = 0;
        for(int d:dp){
            res = Math.max(d,res);
        }
        return res;
    }
}