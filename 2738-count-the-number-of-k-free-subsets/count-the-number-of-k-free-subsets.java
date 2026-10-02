class Solution {
    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Arrays.sort(nums); 
        Map<Integer, Integer> size = new HashMap(); 
        int m = 0; 
        for (var x : nums) {
            size.put(x, 1 + size.getOrDefault(x-k, 0)); 
            size.remove(x-k); 
            m = Math.max(m, size.get(x)); 
        }
        long[] fib = new long[m+2]; 
        fib[0] = fib[1] = 1; 
        for (int i = 2; i < m+2; ++i) fib[i] = fib[i-2] + fib[i-1]; 
        long ans = 1; 
        for (var v : size.values()) 
            ans *= fib[v+1]; 
        return ans; 
    }
}