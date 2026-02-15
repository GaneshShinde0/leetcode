/*
Algorithm:

1. Initialization: Set up DP array and endI list.
2. Ride Grouping: Organize Rides by their end locations.
3. Dynamic Programming: Iterate through each stop, calculating the maximum pearnings possible by either continuiing from the previous stop or ending a ride at the current stop.
4. Return result: Return the maximum earnings at the final stop.
*/

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n+1];
        List<int[]>[] endI = new List[n+1];
        Arrays.setAll(endI, i->i==0?null:new ArrayList<>());
        for(int[] r:rides) endI[r[1]].add(r);
        for(int i=1;i<=n;i++){
            dp[i] = dp[i-1];
            for(int[] r:endI[i]){
                dp[i] = Math.max(dp[i],dp[r[0]]+r[1]-r[0]+r[2]);
            }
        }
        return dp[n];
    }
}