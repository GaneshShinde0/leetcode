class Solution {
    // Custom modular exponentiation method
    private int modPow(long base, long exp) {
        long res = 1;
        long mod = 1_000_000_007;
        base %= mod;
        
        while (exp > 0) {
            // If exp is odd, multiply the base with the result
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            // Square the base and halve the exponent
            base = (base * base) % mod;
            exp >>= 1;
        }
        return (int) res;
    }

    public List<Integer> powerUpdate(int[] nums, int p, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int num : nums) {
            list.add(num);
        }
        
        for (int i = 0; i < queries.length; i++) {
            int low = 0, high = list.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid) > queries[i][0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            list.add(low, queries[i][0]);
            
            int kthLargestValue = list.get(list.size() - queries[i][1]);
            
            // Use the custom modPow method instead of BigInteger
            p = modPow(p, kthLargestValue);
            ans.add(p);
        }

        return ans;
    }
}