class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        return longestOnes(nums,1);
    }

    public int longestOnes(int[] nums, int k) {
        int left =0, right =0, zeroCount =0, n = nums.length, res = 0;
        while(right<n){
            if(nums[right]==0) zeroCount++;
            while(zeroCount>k){
                if(nums[left]==0){
                    zeroCount--;
                }
                res = Math.max(res, right-left);
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
}