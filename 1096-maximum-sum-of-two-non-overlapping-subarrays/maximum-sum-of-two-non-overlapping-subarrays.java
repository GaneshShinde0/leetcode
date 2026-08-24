class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[][] left = new int[n][2];   // left[i][k]: max sum of length lens[k] subarray ending at or before i
        int[][] right = new int[n][2];  // right[i][k]: max sum of length lens[k] subarray starting at or after i

        int[] lens = {firstLen, secondLen};

        for (int k = 0; k < 2; k++) {
            int len = lens[k];

            // build left array
            for (int i = 0; i < n; i++) {
                int val = -1; // sentinel: no valid subarray of this length ending at i
                if (i - len + 1 >= 0) {
                    val = prefix[i + 1] - prefix[i - len + 1];
                }
                int prev = (i > 0) ? left[i - 1][k] : -1;
                left[i][k] = Math.max(prev, val);
            }

            // build right array
            for (int i = n - 1; i >= 0; i--) {
                int val = -1; // sentinel: no valid subarray of this length starting at i
                if (i + len - 1 <= n - 1) {
                    val = prefix[i + len] - prefix[i];
                }
                int next = (i < n - 1) ? right[i + 1][k] : -1;
                right[i][k] = Math.max(next, val);
            }
        }

        int ans = 0;
        // i is the last index of the "left part"; i+1 starts the "right part"
        for (int i = 0; i < n - 1; i++) {
            int a = left[i][0], b = right[i + 1][1];   // firstLen on left, secondLen on right
            if (a >= 0 && b >= 0) ans = Math.max(ans, a + b);

            int c = left[i][1], d = right[i + 1][0];   // secondLen on left, firstLen on right
            if (c >= 0 && d >= 0) ans = Math.max(ans, c + d);
        }

        return ans;
    }
}