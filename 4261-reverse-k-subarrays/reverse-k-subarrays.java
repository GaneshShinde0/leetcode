class Solution {
    public int[] reverseSubarrays(int[] nums, int k) {
        int window = (nums.length/k);
        for(int i=0;i<nums.length;i+=window){
            reverse(nums, i, i+window-1);
        }
        return nums;
    }
    private void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]= temp;
            start++;
            end--;
        }
    }
}