class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int res = 0;

        // Iterate over all possible subarrays
        for (int i = 0; i < n; i++) {
            int targetCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target) targetCount++;
                int len = j - i + 1;
                if (targetCount * 2 > len) res++;
            }
        }

        return res;
    }
}
