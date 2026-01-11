//Input: target = 7, nums = [2,3,1,2,4,3]
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, n = nums.length, right = 0, minSize = n+1, sum =0;
        for(;right<n;right++){
            sum+=nums[right];
            while(left<=right && sum>=target){
                minSize = Math.min(minSize, right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return minSize==(n+1)?0:minSize;
    }
}