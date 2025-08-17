class Solution {
    public int xorAfterQueries1(int[] nums, int[][] queries) {
        for(int[] query:queries){
            int idx = query[0];
            int r = query[1];
            int k =query[2];
            int v = query[3];
            for(int i=idx;i<=r;i+=k){
                nums[i]=(int) ((1l*nums[i]*v)%MOD);
            }
        }
        int res =0;
        for(int i:nums){
            res^=i;
        }
        return res;
    }

    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        // Step 1: For each index, track all multipliers
        List<List<Integer>> multipliers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            multipliers.add(new ArrayList<>());
        }

        for (int[] query : queries) {
            int idx = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            // Only go through affected indices
            for (int i = idx; i <= r; i += k) {
                multipliers.get(i).add(v);
            }
        }

        // Step 2: Apply all multipliers per index
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            for (int v : multipliers.get(i)) {
                val = (val * v) % MOD;
            }
            nums[i] = (int) val;
        }

        // Step 3: Compute XOR
        int res = 0;
        for (int val : nums) {
            res ^= val;
        }
        return res;
    }
}
