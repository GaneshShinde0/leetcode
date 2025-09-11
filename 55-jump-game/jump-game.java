class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for(int i=0;i<nums.length;i++){
            if(reachable>=i) reachable = Math.max(nums[i]+i,reachable);
        }
        return reachable>=nums.length-1;
    }
} 