class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currSum=0, left = 0, right =0, res = Integer.MAX_VALUE;
        int n = nums.length;
        for(;right<n;right++){
            currSum+=nums[right];
            while(currSum>=target){
                res = Math.min(res,right-left+1);
                currSum-=nums[left];
                left++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}