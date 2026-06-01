class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            int missing = nums[mid]-nums[0]-mid;
            if(missing<k){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        int remainder = k-(nums[right]-nums[0]-right);
        return nums[right]+remainder;
    }
}