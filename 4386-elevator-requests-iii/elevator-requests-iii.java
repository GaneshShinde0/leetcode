class Solution {
    public long elevatorRequests(int n, int start, int[][] requests) {
        int m = requests.length;
        long inf = Long.MAX_VALUE / 4; // Prevent overflow on addition
        long[][] dp = new long[1 << m][m];
        
        // 1. Initialize with Infinity
        for (long[] row : dp) {
            Arrays.fill(row, inf);
        }
        
        // 2. Base Cases: Travel from 'start' to the very first request
        for (int i = 0; i < m; i++) {
            long travelTime = Math.abs((long) start - requests[i][1]);
            dp[1 << i][i] = Math.max((long) requests[i][0], travelTime);
        }
        
        // 3. The Bitmask DP Blueprint (The 3 Loops)
        for (int mask = 1; mask < (1 << m); mask++) {
            for (int u = 0; u < m; u++) {
                // If request 'u' is NOT in 'mask' or state is unreachable, skip
                if ((mask & (1 << u)) == 0 || dp[mask][u] == inf) continue;
                
                long currentTime = dp[mask][u];
                int currentFloor = requests[u][1];
                
                for (int v = 0; v < m; v++) {
                    // If request 'v' IS already in 'mask', skip
                    if ((mask & (1 << v)) != 0) continue;
                    
                    // Transition: travel from floor u to floor v
                    long travelTime = Math.abs((long) currentFloor - requests[v][1]);
                    long finishTime = Math.max((long) requests[v][0], currentTime + travelTime);
                    
                    int nextMask = mask | (1 << v); // Turn on v's bit
                    dp[nextMask][v] = Math.min(dp[nextMask][v], finishTime);
                }
            }
        }
        
        // 4. Find minimum time in the completely full mask
        long ans = inf;
        int fullMask = (1 << m) - 1;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[fullMask][i]);
        }
        
        return ans;
    }
}
class SolutionInitial {
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