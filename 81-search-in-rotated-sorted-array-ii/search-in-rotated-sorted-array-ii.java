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
            boolean isTargetInLeftRange = nums[left]<=target && target<=nums[mid];
            if(isLeftSorted){
                if(isTargetInLeftRange){
                    right = mid-1;
                }else{
                    left= mid+1;
                }
            }else{
                boolean isTargetInRightRange = target>=nums[mid] && target<=nums[right];
                if(isTargetInRightRange){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}