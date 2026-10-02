class Solution {
    // time = O(n + q), space = O(n)
    Random random = new Random();
    public boolean[] validSubarrays(int[] nums, int k, int l0, int r0, int q) {
        int n = nums.length;
        long[] s = new long[n + 1];
        HashMap<Integer, Long> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (!hash.containsKey(x)) hash.put(x, random.nextLong());
            s[i + 1] = s[i] ^ hash.get(x);
        }

        int[] l1 = calcLeft(nums, k + 1);
        int[] l2 = calcLeft(nums, k);
        
        boolean[] res = new boolean[q];
        int l = 0, r = 0;
        for (int i = 0; i < q; i++) {
            if (i == 0) {
                l = l0;
                r = r0;
            } else {
                int g = res[i - 1] ? l + r : r - l;
                int nl = (l ^ g) % n;
                int nr = (r ^ g) % n;
                if (nl > nr) {
                    int t = nl;
                    nl = nr;
                    nr = t;
                }
                l = nl;
                r = nr;
            }
            res[i] = s[r + 1] == s[l] && l1[r] <= l && l < l2[r]; 
        }
        return res;
    }

    private int[] calcLeft(int[] nums, int k) {
        int n = nums.length;
        int[] lefts = new int[n];
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0, l = 0; i < n; i++) {
            int x = nums[i];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            while (cnt.size() >= k) {
                int y = nums[l++];
                cnt.put(y, cnt.get(y) - 1);
                if (cnt.get(y) == 0) cnt.remove(y);
            }
            lefts[i] = l;
        }
        return lefts;
    }
}