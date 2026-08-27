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

So basically this looks like 3D DP


*/
class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int n = houses.length, INF = Integer.MAX_VALUE/4;
        int[][] cost = new int[n][n];
        int[][] dp = new int[n+1][k+1];
        for(int[] d:dp) Arrays.fill(d,INF);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int median = houses[(j+i)/2];
                for(int m=i;m<=j;m++){
                    cost[i][j] += Math.abs(median-houses[m]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                if(j==0) dp[i+1][j+1] = cost[0][i]; // When j==0 (1) postboxes cost dp[i][j] => dp[i][0] will be cost of first i houses using (0)(1) postboxes.
                else{
                    for(int m=0;m<=i;m++){
                        dp[i+1][j+1]=Math.min(dp[i+1][j+1], dp[m][j]+cost[m][i]); // first m houses using first j post offices + cost of m to ith houses.
                    }
                }
            }
        }
        return dp[n][k];
    }
    
}