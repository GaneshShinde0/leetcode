class Solution {

    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int pre = nums[0];
        int cnt = 0;
        for (int n : nums) {
            if (n == pre) {
                cnt++;
            } else {
                pre = n;
                cnt = 1;
            }
            if (cnt * k > nums.length) {
                return false;
            }
        }
        return true;
    }
}