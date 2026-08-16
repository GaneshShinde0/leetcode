class Solution {
    public long elevatorRequests(int n, int start, int[][] requests) {
        int m = requests.length;
        int totalMasks = 1<<m;
        long inf = Long.MAX_VALUE/4;
        long[][] dp = new long[totalMasks][m];
        
        for(long[] d:dp) Arrays.fill(d,inf);

        for(int i=0;i<m;i++){
            long travelTime = Math.abs((long) start-requests[i][1]);
            long time = Math.max(travelTime, (long) requests[i][0]);
            dp[1<<i][i] = time;
        }

        for(int mask = 1; mask<totalMasks; mask++){
            for(int last = 0; last<m; last++){
                if((mask & (1<<last))==0) continue;
                long currentTime = dp[mask][last];
                int currentFloor = requests[last][1];
                
                for(int next = 0;next<m;next++){
                    if((mask & (1<<next))!=0) continue;
                    long travelTime = Math.abs((long) currentFloor-requests[next][1]);
                    long newTime = Math.max(currentTime + travelTime, (long) requests[next][0]);

                    int newMask = mask | (1<<next);
                    dp[newMask][next] = Math.min(dp[newMask][next], newTime);
                }
            }
        }

        int fullMask = totalMasks-1;
        long res = inf;
        for(int last = 0;last<m;last++){
            res = Math.min(res, dp[fullMask][last]);
        }
        return res;
    }
}