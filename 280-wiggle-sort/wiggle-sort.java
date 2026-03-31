/*
Input: nums = [3,5,2,1,6,4]
[3,5,2,6,1,4]
[1,2,3,4,5,6]

1,6,2,5,3,5
*/
class Solution {
    public void wiggleSort(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(i%2==0){
                if(nums[i]>nums[i+1]){ // Even should be lesser than left and right, left will already get satisfied with previous condition.
                    swap(nums,i,i+1);
                }
            }else{
                if(nums[i]<nums[i+1]){ // Odd index should be greater than left and right. (Left already satisfied with previous condition)
                    swap(nums,i,i+1);
                }
            }
        }
    }
    public void wiggleSortInitial(int[] nums) {
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