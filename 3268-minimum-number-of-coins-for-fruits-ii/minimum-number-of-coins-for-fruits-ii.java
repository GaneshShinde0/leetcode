class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        dp[0] = prices[0];
        q.add(0);

        for (int i = 1; i < n; ++i) {
            dp[i] = dp[q.peekFirst()] + prices[i];
            while (!q.isEmpty() && q.peekFirst() + q.peekFirst() + 1 < i) {
                q.pollFirst();
            }
            while (!q.isEmpty() && dp[q.peekLast()] >= dp[i]) {
                q.pollLast();
            }
            q.add(i);
        }
        return dp[q.peekFirst()];
    }
}