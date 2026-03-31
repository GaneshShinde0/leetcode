/*
Input: nums = [3,5,2,1,6,4]
[3,5,2,6,1,4]
[1,2,3,4,5,6]

1,6,2,5,3,5
*/
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);    
        for(int i=1;i<nums.length-1;i+=2){
            swap(nums,i,i+1);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}