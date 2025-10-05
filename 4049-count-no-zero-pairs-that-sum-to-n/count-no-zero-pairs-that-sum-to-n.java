import java.util.*;

class Solution {
    private long[][][][][] dp;
    private int[] a;
    private int sz;

    private long solve(int i, int car, int done1, int done2, int started) {
        if (i == sz) {
            return (car == 0 && started == 1) ? 1 : 0;
        }
        if (dp[i][car][done1][done2][started] != -1) {
            return dp[i][car][done1][done2][started];
        }
        if (done1 == 1 && done2 == 1) return 0;

        long ans = 0;

        if (a[i] == car) {
            ans += solve(i + 1, 0, 1, 1, started);
        }

        if (done1 == 1) {
            for (int jj = 1; jj <= 9; jj++) {
                int curr = jj + car;
                int carry = curr / 10;
                curr %= 10;
                if (curr == a[i]) {
                    ans += solve(i + 1, carry, done1, done2, 1);
                }
            }
        }

        if (done2 == 1) {
            for (int ii = 1; ii <= 9; ii++) {
                int curr = ii + car;
                int carry = curr / 10;
                curr %= 10;
                if (curr == a[i]) {
                    ans += solve(i + 1, carry, done1, done2, 1);
                }
            }
        }

        if (done1 == 0 && done2 == 0) {
            for (int ii = 1; ii <= 9; ii++) {
                for (int jj = 1; jj <= 9; jj++) {
                    int curr = ii + jj + car;
                    int carry = curr / 10;
                    curr %= 10;
                    if (curr == a[i]) {
                        ans += solve(i + 1, carry, 1, done2, 0);
                        ans += solve(i + 1, carry, done1, 1, 0);
                        ans += solve(i + 1, carry, done1, done2, started);
                    }
                }
            }
        }

        dp[i][car][done1][done2][started] = ans;
        return ans;
    }

    public long countNoZeroPairs(long n) {
        // Convert number to digit array in reverse order
        List<Integer> digits = new ArrayList<>();
        long N = n;
        while (N > 0) {
            digits.add((int) (N % 10));
            N /= 10;
        }

        sz = digits.size();
        a = new int[sz];
        for (int i = 0; i < sz; i++) a[i] = digits.get(i);

        dp = new long[sz][2][2][2][2];
        for (long[][][][] d1 : dp)
            for (long[][][] d2 : d1)
                for (long[][] d3 : d2)
                    for (long[] d4 : d3)
                        Arrays.fill(d4, -1);

        return solve(0, 0, 0, 0, 1);
    }
}