class Solution {
    public boolean canJump(int[] nums) {
        int currMax = nums[0];
        for(int i=0;i<nums.length;i++){
            if(i>currMax) return false;
            currMax = Math.max(currMax, nums[i]+i);
        }
        return true;
    }
}