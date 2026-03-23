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
            boolean leftLessThanMid = nums[left]<=nums[mid];
            boolean leftLessThanTarget = nums[left]<=target;
            boolean existInFirst = leftLessThanMid ^ leftLessThanTarget;
            if(existInFirst){
                if(leftLessThanMid){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }else{
                if(nums[mid]<target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}