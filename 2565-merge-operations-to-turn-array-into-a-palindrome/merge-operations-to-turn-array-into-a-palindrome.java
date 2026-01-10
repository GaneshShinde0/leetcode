/*
Input: nums = [4,3,2,1,2,3,1]
left = 0
right = 6
n = 7
mergeCount = 0

nums = [4,3,2,1,2,4]
mergeCount = 1;
left = 0
right = 5

nums = [4,3,2,1,2,4]
mergeCount = 1;
left = 1
right = 4


nums = [4,3,2,3,4]
mergeCount = 2;
left = 1
right = 3



*/
class Solution {
    public int minimumOperations(int[] nums) {
        int left = 0, right = nums.length-1, n =nums.length, mergeCount=0;
        while(left<right){
            if(nums[left]==nums[right]){
                left++;
                right--;
            }else if(nums[left]<nums[right]){
                nums[left+1]+=nums[left];
                mergeCount++;
                left++;
            }else{
                nums[right-1]+=nums[right];
                mergeCount++;
                right--;
            }
        }
        return mergeCount;
    }
}