class Solution {
    public int longestOnes(int[] nums, int k) {
        int res =0, n = nums.length;
        int left = 0,zeroCount=0;
        for(int right=0;right<n;right++){
            if(nums[right]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[left]==0){
                    zeroCount--;
                }
                res = Math.max(res,right-left);
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}