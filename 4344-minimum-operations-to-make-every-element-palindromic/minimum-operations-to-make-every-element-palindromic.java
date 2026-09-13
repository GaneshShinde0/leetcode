class Solution {
    static TreeSet<Long> odd = new TreeSet<>();
    static TreeSet<Long> even = new TreeSet<>();

    static {
        for (int x = 1; x <= 99999; x++) {
            String s = String.valueOf(x);
            long p = Long.parseLong(s + new StringBuilder(s.substring(0, s.length() - 1)).reverse());
            if (p <= 1_000_000_000) ((p & 1) == 1 ? odd : even).add(p);
            p = Long.parseLong(s + new StringBuilder(s).reverse());
            if (p <= 1_000_000_000) ((p & 1) == 1 ? odd : even).add(p);
        }
    }

    public long minOperations(int[] nums) {
        long res = 0;
        for (int num : nums) {
            TreeSet<Long> set = (num & 1) == 1 ? odd : even;
            Long lo = set.floor(1l * num);
            Long hi = set.ceiling(1l * num);
            long best = Long.MAX_VALUE;
            if (lo != null) best = Math.min(best, (num - lo) / 2L);
            if (hi != null) best = Math.min(best, (hi - num) / 2L);
            res += best;
        }
        return res;
    }
}