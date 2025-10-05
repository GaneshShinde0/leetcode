class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            } else {
                break;
            }
        }
        Arrays.sort(nums);
        if (k % 2 == 1) {
            nums[0] = -nums[0];
        }
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}