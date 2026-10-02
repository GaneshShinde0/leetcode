class Solution {

    int n;
    int[] power;
    Long[][] dp;

    public long minimumTime(int[] p) {
        power = p;
        n = power.length;
        dp = new Long[n + 1][1 << (n + 1)];
        return killOrSpare(1 << n, 1);
    }

    private long killOrSpare(int killed, int gain) {
        if (gain == n + 1) return 0;
        if (dp[gain][killed] != null) return dp[gain][killed];

        long days = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((killed & (1 << i)) == 0) {
                int dayReqToKill = (power[i] + gain - 1) / gain;
                long daysToKillAll = dayReqToKill + killOrSpare(killed | (1 << i), gain + 1);
                days = Math.min(days, daysToKillAll);
            }
        }
        return dp[gain][killed] = days;
    }
}