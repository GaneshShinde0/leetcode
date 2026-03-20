class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m - k + 1][n - k + 1];
        for (int[] arr : res)
            Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int idx = 0;
                int[] arr = new int[k * k];
                for (int subRow = i; subRow < i + k; subRow++) {
                    for (int subCol = j; subCol < j + k; subCol++) {
                        arr[idx] = grid[subRow][subCol];
                        idx++;
                    }
                }
                Arrays.sort(arr);
                for (idx = 1; idx < k * k; idx++) {
                    if (arr[idx] == arr[idx - 1])
                        continue;
                    res[i][j] = Math.min(arr[idx] - arr[idx - 1], res[i][j]);
                }
                if (k == 1 || res[i][j] == Integer.MAX_VALUE)
                    res[i][j] = 0;
            }
        }
        return res;
    }
}