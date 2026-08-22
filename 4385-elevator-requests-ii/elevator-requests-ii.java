class Solution {
    public long elevatorRequests(int n, int start, int[] requests) {
        int m = 0;
        for(int req:requests) if(start!=req) m++;

        if(m==0) return 0L;
        int a[] = new int[m], idx = 0;
        for(int req:requests) if(start!=req) a[idx++]=req;
        Arrays.sort(a);

        long INF = Long.MAX_VALUE/4;
        long[][] dpL = new long[m][m];
        long[][] dpR = new long[m][m];
        for(long[] dp:dpL) Arrays.fill(dp, INF);
        for(long[] dp:dpR) Arrays.fill(dp, INF);

        for(int i=0;i<m;i++){
            long cost = 1l*Math.abs(1l*start - a[i])*m;
            dpL[i][i] = cost;
            dpR[i][i] = cost;
        }

        for(int len = 2; len<=m; len++){
            int remaining = m-(len-1);

            for(int l=0;l+len-1<m;l++){
                int r = l+len-1;

                // Extend Right: previous interval [l,r-1]
                if(r-1>=l){
                    long fromLeft = dpL[l][r-1];
                    long fromRight = dpR[l][r-1];
                    long best = Math.min(
                        fromLeft==INF?INF:fromLeft+Math.abs((long)a[r]-a[l])*remaining,
                        fromRight==INF?INF:fromRight+Math.abs((long)a[r]-a[r-1])*remaining
                    );
                    dpR[l][r] = Math.min(dpR[l][r], best);
                }

                // Extend Left: previous interval [l+1, r]
                if(l+1<=r){
                    long fromLeft = dpL[l+1][r];
                    long fromRight = dpR[l+1][r];
                    long best = Math.min(
                        fromLeft == INF?INF:fromLeft+Math.abs((long)a[l+1]-a[l])*remaining,
                        fromRight ==INF?INF:fromRight+Math.abs((long)a[r]-a[l])*remaining
                    );
                    dpL[l][r] = Math.min(dpL[l][r], best);
                }
            }
        }
        return Math.min(dpL[0][m-1], dpR[0][m-1]);
    }
}