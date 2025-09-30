class Solution {
    /*
    We start at either step 0 or step 1. The target is to reach either last or second last step. Whichever is miniumum.
    Step 1: Identify a recurrence relation between sub problems.
    Here, minCost(i) = cost[i]+min(mincost(i-1),mincost(i-2))
    base cases mincost(0) = cost[0]
mincost(1) = cost[1];
    */
    // Approach 1 Recursion
    public int minCostClimbingStairsTLE(int[] cost) {
        int n = cost.length;    
        return Math.min(minCostTLE(cost,n-1), minCostTLE(cost, n-2));
    }

    private int minCostTLE(int[] cost, int n){
        if(n<0) return 0;
        if(n==0 || n==1) return cost[n];
        return cost[n] + Math.min(minCostTLE(cost, n-1), minCostTLE(cost, n-2));
    }

    int[] dp;
    public int minCostClimbingStairsTLE2(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        return Math.min(minCostTLE2(cost,n-1), minCostTLE2(cost, n-2));
    }

    private int minCostTLE2(int[] cost, int n){
        if(n<0) return 0;
        if(n==0||n==1) return cost[n];
        if(dp[n]!=0) return dp[n];
        dp[n]=cost[n]+Math.min(minCostTLE2(cost,n-1),minCostTLE2(cost,n-2));
        return dp[n];
    }

    // Optimization Bottom Up DP : Convert Recursion to Iteration
    public int minCostClimbingStairsBottomUp(int[] cost){
        int n = cost.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            if(i<2)dp[i]=cost[i];
            else dp[i] = cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }

    public int minCostClimbingStairs(int[] cost){
        int n = cost.length;
        int first = cost[0], second = cost[1];

        if(n<=2) return Math.min(first,second);
        for(int i=2;i<n;i++){
            int curr = cost[i]+Math.min(first,second);
            first = second;
            second = curr;
        }
        return Math.min(first,second);
    }
}