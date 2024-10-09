class ClimbingStars {
    public int climbStairsSlowest(int n) {
        if(n<=3) return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public int climbStairs(int n) {
        if (n <= 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
