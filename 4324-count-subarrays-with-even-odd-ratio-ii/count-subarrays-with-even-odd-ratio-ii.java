import java.util.*;

class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void add(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int sum(int idx) {
            int ans = 0;
            while (idx > 0) {
                ans += bit[idx];
                idx -= idx & -idx;
            }
            return ans;
        }
    }

    public long countRatioSubarrays(int[] nums, int a, int b) {

        int n = nums.length;
        long[] value = new long[n + 1];
        int even = 0;
        value[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] % 2 == 0)
                even++;
            value[i] = 1L * even * (a + b) - 1L * i * a;
        }

        long[] sorted = value.clone();
        Arrays.sort(sorted);
        Map<Long, Integer> map = new HashMap<>();
        int id = 1;
        for (long x : sorted) {
            if (!map.containsKey(x))
                map.put(x, id++);
        }

        Fenwick bit = new Fenwick(id + 2);
        long ans = 0;
        int seen = 0;
        for (int i = 0; i <= n; i++) {
            int idx = map.get(value[i]);
            ans += seen - bit.sum(idx - 1);
            bit.add(idx, 1);
            seen++;
        }

        return ans;
    }
}