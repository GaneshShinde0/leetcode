class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int m = nums.length, n = pattern.length;
        int res = 0;
        
        for (int i = 0; i < m - n; ++i) {
            boolean chk = true;
            for (int j = 0; j < n; ++j)
                if (Integer.compare(nums[i + j + 1], nums[i + j]) != pattern[j]) {
                    chk = false;
                    break;
                }
            if (chk) ++res;
        }

        return res;
    }
}