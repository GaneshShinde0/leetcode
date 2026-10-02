class Solution {
    // time = O(n^2), space = O(n)
    public int minimumCost(String sentence, int k) {
        // corner case
        if (sentence == null || sentence.length() == 0 || k <= 0) return 0;

        String[] strs = sentence.split(" ");
        int n = strs.length, res = 0;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int len = strs[i - 1].length();
            dp[i] = dp[i - 1] + (k - len) * (k - len);
            if (i == n) res = dp[i - 1];
            int cur = len;
            for (int j = i - 1; j >= 1; j--) {
                cur += strs[j - 1].length() + 1;
                if (k - cur >= 0) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + (k - cur) * (k - cur));
                    res = Math.min(res, dp[j - 1]);
                } else break;
            }
        }
        return res;
    }
}