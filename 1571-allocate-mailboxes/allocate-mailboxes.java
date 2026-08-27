/*
Lets look at constraints.
1 <= k <= houses.length <= 100
1 <= houses[i] <= 104
All the integers of houses are unique.

Houses and K count is less than or equal to 100. 
This looks like DP.

We will have to arrange in such a way that we can give
[0...i] to k1
[i+1...j] to k2
[j+1...k] to k3


*/
class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int n = houses.length, INF = Integer.MAX_VALUE/4;
        int[][] cost = new int[n+1][n+1]; // Adding +1 to avoid off by one errors everywhere.
        int[][] dp = new int[n+1][k+1];
        for(int[] d:dp) Arrays.fill(d,INF);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int median = houses[(j+i)/2];
                for(int m=i;m<=j;m++){
                    cost[i+1][j+1] += Math.abs(median-houses[m]); // Cost of putting one postbox for houses i to j. (1 indexed)
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                if(j==0) dp[i+1][j+1] = cost[1][i+1]; // When J=0, cost of putting first i+1 houses using one post box will be cost[1][i+1]
                else{
                    for(int m=0;m<=i;m++){
                        dp[i+1][j+1]=Math.min(dp[i+1][j+1], dp[m][j]+cost[m+1][i+1]); // first m houses using first j post offices + cost of m+1 to ith houses.
                    }
                }
            }
        }
        return dp[n][k];
    }
    
}