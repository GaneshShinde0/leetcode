class Solution {
    public int numberOfWays(int n, int[] limit) {
        int mod = 1_000_000_007;
        Arrays.sort(limit);
        int prv = -1;
        int count = 0;
        for (int i = 0; i < limit.length; i++) {
            if (limit[i] >= n)
                limit[i] = n - 1;
            if (limit[i] != prv) {
                count++;
                prv = limit[i];
            }
        }
        int[][] arr = new int[count][];
        int idx = 0;
        count = 1;
        for (int i = 1; i < limit.length; i++) {
            if (limit[i] != limit[i - 1]) {
                arr[idx++] = new int[] { limit[i - 1], count };
                count = 1;
            } else {
                count++;
            }
        }
        arr[idx] = new int[] { limit[limit.length - 1], count };
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i][1] += arr[i + 1][1];
        }
        int l = 0;
        int r = arr.length - 1;
        if (arr[r][0] * 2 < n)
            return 0;
        while (arr[l][0] + arr[r][0] < n) {
            l++;
        }
        int left = n - arr[r][0];
        while (r > 0 && arr[r - 1][0] >= n - left) {
            r--;
        }
        long res = 0;
        prv = left - 1;
        int max = left - 1;
        long sum = 0;
        while (l < arr.length) {
            int prvNext = Math.max(max + 1, n - arr[r][0]);
            res = (res + sum * (prvNext - prv)) % mod;
            prv = prvNext;
            if (l < r) {
                sum = (long) (arr[l][1] - 1) * arr[r][1] % mod;
            } else {
                sum = (long) (arr[r][1] - 1) * arr[l][1] % mod;
            }
            while (r > 0 && arr[l][0] + arr[r - 1][0] >= n) {
                r--;
                prvNext = n - arr[r][0];
                if (prvNext != prv) {
                    res = (res + sum * (prvNext - prv)) % mod;
                    prv = prvNext;

                }
                if (l < r) {
                    sum = (long) (arr[l][1] - 1) * arr[r][1] % mod;
                } else {
                    sum = (long) (arr[r][1] - 1) * arr[l][1] % mod;
                }
            }
            max = arr[l][0];
            l++;
        }
        res = (res + sum * (n - prv)) % mod;
        return (int) res;
    }
}