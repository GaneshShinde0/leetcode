class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        int[][] dp = new int[n+1][1<<m];
        for(int[] d:dp) Arrays.fill(d, Integer.MAX_VALUE/4);
        dp[0][0] = 0;

        for(int i=0;i<n;i++){
            for(int mask = 0; mask<(1<<m); mask++){
                for(int j=0;j<m;j++){
                    if((mask&(1<<j))!=0)continue;
                    int[] b = bikes[j], w = workers[i];
                    int dist = Math.abs(b[0]-w[0])+Math.abs(b[1]-w[1]);
                    dp[i+1][mask | (1<<j)] = Math.min(dp[i+1][mask | (1<<j)], dp[i][mask]+dist);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        int upperLimit = (1<<m)-1;
        for(int d:dp[n]){
            res = Math.min(res,d);
        }
        return res;
    }
}