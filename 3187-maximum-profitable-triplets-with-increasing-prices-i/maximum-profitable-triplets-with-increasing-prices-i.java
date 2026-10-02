//T:O(n lg maxPrice)
//S:O(maxPrice)
class Solution {
    public int maxProfit(int[] prices, int[] profits) {
        int maxPrice = 0, n = prices.length;
        for (int price : prices) {
            maxPrice = Math.max(maxPrice, price);
        }

        int[] bitForMaxLeft = new int[maxPrice + 1], bitForMaxRight = new int[maxPrice + 1];
        int[] maxLeft = new int[n];

        for (int i = 0; i < n; i++) {
            maxLeft[i] = get(bitForMaxLeft, prices[i] - 1);
            update(bitForMaxLeft, prices[i], profits[i]);
        }

        int res = -1;
        for (int i = n - 1; i >= 0; i--) {
            int offset = maxPrice - prices[i] + 1;
            int maxRight = get(bitForMaxRight, offset - 1);

            if (maxLeft[i] > 0 && maxRight > 0) {
                res = Math.max(res, maxLeft[i] + profits[i] + maxRight);
            }
            update(bitForMaxRight, offset, profits[i]);
        }

        return res;
    }

    private void update(int[] bit, int price, int profit) {
        for (int i = price; i > 0 && i < bit.length; i = i + (i & -i)) {
            bit[i] = Math.max(bit[i], profit);
        }
    }

    private int get(int[] bit, int price) {
        int profit = 0;
        for (int i = price; i > 0; i = i - (i & -i)) {
            profit = Math.max(bit[i], profit);
        }

        return profit;
    }
}