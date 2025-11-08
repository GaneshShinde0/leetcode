class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int curr = 1;
        int res = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                curr++;
            }else{
                curr=1;
            }
            res = Math.max(curr, res);
        }
        return res;
    }
}