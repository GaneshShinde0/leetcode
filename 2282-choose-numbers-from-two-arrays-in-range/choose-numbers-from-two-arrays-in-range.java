class Solution {
    public int countSubranges(int[] nums1, int[] nums2) {
        final int mod = 1_000_000_007; 
        long ans = 0; 
        Map<Integer, Long> freq = new HashMap(); 
        for (int i = 0; i < nums1.length; ++i) {
            Map<Integer, Long> ff = new HashMap(); 
            ff.merge(nums1[i], 1l, Long::sum); 
            ff.merge(-nums2[i], 1l, Long::sum); 
            for (var elem : freq.entrySet()) {
                int k = elem.getKey(); 
                long v = elem.getValue(); 
                ff.put(k+nums1[i], (ff.getOrDefault(k+nums1[i], 0l) + v) % mod);
                ff.put(k-nums2[i], (ff.getOrDefault(k-nums2[i], 0l) + v) % mod); 
            }
            freq = ff; 
            ans = (ans + freq.getOrDefault(0, 0l)) % mod; 
        }
        return (int) ans; 
    }
}