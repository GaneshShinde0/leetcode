class Solution {
    // time = O(n), space = O(n)
    public int maxFrequencyScore(int[] nums, int k) {
        long mod = (long)(1e9 + 7);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        HashMap<Integer, HashMap<Integer, Long>> pw = new HashMap<>();
        for (int x : map.keySet()) {
            int y = map.get(x);
            long p = 1;
            pw.putIfAbsent(x, new HashMap<>());
            for (int i = 0; i < y; i++) {
                p = p * x % mod;
                pw.get(x).put(i + 1, p);
            }
        }

        int n = nums.length;
        map.clear();
        long sum = 0, res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            int x = nums[i], cnt = map.getOrDefault(x, 0);
            map.put(x, map.getOrDefault(x, 0) + 1);
            sum = ((sum + pw.get(x).get(cnt + 1)) % mod - pw.get(x).getOrDefault(cnt, 0L) + mod) % mod;
            if (i - j + 1 > k) {
                int y = nums[j++];
                map.put(y, map.get(y) - 1);
                cnt = map.get(y);
                sum = ((sum + pw.get(y).getOrDefault(cnt, 0L)) % mod - pw.get(y).get(cnt + 1) + mod) % mod;
            }
            if (i - j + 1 == k) res = Math.max(res, sum);
        }
        return (int) res;
    }
}