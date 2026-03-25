class Solution {
    public int climbStairs(int n, int[] costs) {
        int cost = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<4 && i+j<=n;j++){
                dp[i+j] = Math.min(dp[i+j],dp[i]+costs[i+j-1]+j*j);
            }
        }
        return dp[n];
    }
}

/*
costs = [1,2,3,4]
dp= [0, m, m, m]

i =  0;
    dp[0] = 0+1+1=>2
    dp[1] = 0+2+4 =>6
    dp[2] = 0+3+9 => 12
i = 1;
    dp[] 

*/