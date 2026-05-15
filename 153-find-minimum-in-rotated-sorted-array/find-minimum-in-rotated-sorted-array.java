/*
3,4,5,1,2

1 2 3 4 5 6
6 5 1 2 3 4
*/
class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        int res = 0;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid]>=nums[start]){
                if(nums[end]<nums[mid]){
                    start=mid+1;
                }else{
                    end = mid;
                }
            }else{
                end = mid;
            }
        }
        return nums[end];
    }
}