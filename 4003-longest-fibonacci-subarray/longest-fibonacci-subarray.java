class Solution {
    public int longestSubarray(int[] nums) {
        int curr = 2,res=2;
        for(int i=2;i<nums.length;i++){
            if(nums[i]==nums[i-1]+nums[i-2]){
                curr++;
            }else{
                res=Math.max(curr,res);
                curr=2;
            }
        }
        return Math.max(curr,res);
    }
}