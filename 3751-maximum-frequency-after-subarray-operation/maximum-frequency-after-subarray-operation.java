class Solution {
        public int maxFrequency(int[] A, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : A) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }

        int res = 0;
        for (int b : count.keySet()) {
            res = Math.max(res, kadane(A, k, b));
        }

        return count.getOrDefault(k, 0) + res;
    }

    private int kadane(int[] A, int k, int b) {
        int res = 0, cur = 0;
        for (int a : A) {
            if (a == k) {
                cur--;
            }
            if (a == b) {
                cur++;
            }
            if (cur < 0) {
                cur = 0;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}