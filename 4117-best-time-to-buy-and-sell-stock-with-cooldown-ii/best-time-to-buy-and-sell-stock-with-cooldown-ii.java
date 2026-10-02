class Solution {
    public int maxProfit(int[] prices, int cooldown, int[] costs) {
        int n = prices.length;

        int[] sell = new int[n];
        int[] best = new int[n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int previousProfit = 0;
                int previousDay = i - cooldown - 1;
                if (previousDay >= 0) {
                    previousProfit = best[previousDay];
                }

                int currentTransaction = prices[j] - prices[i] - costs[j - i];

                sell[j] = Math.max(sell[j], previousProfit + currentTransaction);
            }

            if (j == 0) {
                best[j] = 0;
            } else {
                best[j] = Math.max(best[j - 1], sell[j]);
            }

        }

        return best[n - 1];
    }
}