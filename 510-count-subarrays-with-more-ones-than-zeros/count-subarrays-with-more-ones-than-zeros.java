class Solution {
    final int MOD = (int) 1e9 + 7;    
    class BinaryIndexTree {
        int n; // n = max prefix sum
        int[] num; // num[x] = how many prefix sum <= x

        BinaryIndexTree(int n) {
            this.n = n;
            this.num = new int[n + 1];
        }

        void edit(int x) {
            while (x <= n) {
                num[x] += 1;
                x = x + lowerBit(x); // right parent or grandparent
            }
        }

        public int sum(int x) {
            int s = 0;
            while (x > 0) {
                s += num[x];
                x = x - lowerBit(x); // left parent or grandparent
            }
            return s;
        }

        int lowerBit (int x) {
            return x & -x;
        }
    }

    public int subarraysWithMoreOnesThanZeroes(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }

        int base = nums.length + 1;
        BinaryIndexTree bit = new BinaryIndexTree(nums.length + base);

        int sum = 0;
        for (int prefix : prefixSum) {
            int shifted = prefix + base;
            // find out how many subarrasys has prefixSum < prefixSum[i]
            sum = (sum + bit.sum(shifted - 1)) % MOD;
            bit.edit(shifted);
        }

        return sum;
    }
}