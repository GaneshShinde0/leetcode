class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return false;
        int left = 0, right = n-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target) return true;
            if(nums[left]==nums[mid]){
                left++;
                continue;
            }
            boolean isLeftSorted = nums[left] <= nums[mid];
            boolean targetInLeftRange = (target >= nums[left] && target < nums[mid]);

            if (isLeftSorted) {
                if (targetInLeftRange) {
                    // Target is in the sorted left half
                    right = mid - 1;
                } else {
                    // Target must be in the right half
                    left = mid + 1;
                }
            } else {
                // Right half must be the sorted one
                boolean targetInRightRange = (target > nums[mid] && target <= nums[right]);
                if (targetInRightRange) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}