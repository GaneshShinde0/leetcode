class Solution {
    public long[] minimumRelativeLosses(int[] prices, int[][] queries) {
        Arrays.sort(prices);
        int n = prices.length;
        long[] sumArr = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            sumArr[i] = sumArr[i - 1] + prices[i - 1];
        }
        
        int m = queries.length;
        int[] ind = new int[m];
        for (int i = 0; i < m; ++i) {
            ind[i] = i;
        }
        ind = Arrays.stream(ind).boxed()
        .sorted((a, b) -> queries[a][0] - queries[b][0])
        .mapToInt(i -> i)
        .toArray();
        int j = 0;
        long[] result = new long[m];
        
        for (int i : ind) {
            int p = queries[i][0];
            int num = queries[i][1];
            int pp = p << 1;
            while (j < n && prices[j] <= p) {
                j++;
            }
            int num1 = Math.min(num, j);
            int left = 1, right = Math.min(num1, n - num);
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (prices[num1 - mid] > pp - prices[n - (num - num1) - mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            num1 -= left - 1;
            long num2 = num - num1;
            result[i] = num2 * pp - (sumArr[n] - sumArr[n - (int) num2]) + sumArr[num1];
        }
        
        return result;
    }
}