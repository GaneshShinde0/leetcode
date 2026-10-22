class Solution {

    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int incBreak = 0, incPos = -1;
        int decBreak = 0, decPos = -1;
        for (int i = 0; i < n; i++) {
            int next = nums[(i + 1) % n];
            if (nums[i] > next) {
                incBreak++;
                incPos = i;
            }

            if (nums[i] < next) {
                decBreak++;
                decPos = i;
            }
        }

        // rotation of increasing
        if (incBreak <= 1) {
            int k = (incPos + 1) % n;
            ans = Math.min(ans, k);
            ans = Math.min(ans, 2 + ((n - k) % n));
        }

        // rotation of decreasing
        if (decBreak <= 1) {
            int k = (decPos + 1) % n;
            ans = Math.min(ans, 1 + k);
            ans = Math.min(ans, 1 + ((n - k) % n));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}