class Solution {
    public long maxCoins(int[] lane1, int[] lane2) {
        long max = lane1[0];
        //dp -> lane, idx, switches
        long[][][] dp = new long[3][lane1.length][3];
        for (int i = 0; i < lane1.length; i++) {
            max = Math.max(max , dp(lane1, lane2, 1, i, 2, dp));
            max = Math.max(max , dp(lane1, lane2, 2, i, 1, dp));
        }
        return max;
    }

    private long dp(int[] lane1, int[] lane2, int lane, int currentIdx, int switches, long[][][] dp) {
        if (currentIdx >= lane1.length) {
            return 0;
        } else {
            if (dp[lane][currentIdx][switches] != 0) {
                return dp[lane][currentIdx][switches];
            }

            // take current
            long take = lane == 1 ? lane1[currentIdx] : lane2[currentIdx];

            //switch line if possible
            long switchLine = 0;
            if (switches > 0) {
                switchLine = dp(lane1, lane2, lane == 1 ? 2 : 1, currentIdx+1, switches - 1, dp);
            }

            //proceed same line
            long sameLine = dp(lane1, lane2, lane, currentIdx + 1, switches, dp);

            dp[lane][currentIdx][switches] =
                    Math.max(
                            //just take
                            Math.max(take,
                                    //take and go same line
                                    take + sameLine),
                            //take and switch line
                            take + switchLine);
            return dp[lane][currentIdx][switches];
        }
    }
}