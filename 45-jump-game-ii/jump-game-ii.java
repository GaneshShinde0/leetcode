class Solution {
    public int jump(int[] nums) {
        int jumps = 0, farthest = 0, curr=0;
        for(int i=0;i<nums.length-1;i++){
            if(i>farthest) return -1;
            farthest = Math.max(farthest, i+nums[i]);
            if(i==curr){
                curr=farthest;
                jumps++;
            }
        }
        return jumps;
    }
}