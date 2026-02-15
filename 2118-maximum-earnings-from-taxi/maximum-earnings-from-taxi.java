/*
Algorithm:

1. Initialization: Set up DP array and ridesEndingAtI list.
2. Ride Grouping: Organize Rides by their end locations.
3. Dynamic Programming: Iterate through each stop, calculating the maximum pearnings possible by either continuiing from the previous stop or ridesEndingAtIng a ride at the current stop.
4. Return result: Return the maximum earnings at the final stop.
*/

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n+1];
        List<int[]>[] ridesEndingAtI = new List[n+1];
        Arrays.setAll(ridesEndingAtI, i->i==0?null:new ArrayList<>());
        for(int[] ride:rides) ridesEndingAtI[ride[1]].add(ride);
        for(int i=1;i<=n;i++){
            dp[i] = dp[i-1];
            for(int[] ride:ridesEndingAtI[i]){
                dp[i] = Math.max(dp[ride[0]]+ride[1]-ride[0]+ride[2],dp[i]);
            }
        }
        return dp[n];
    }
}