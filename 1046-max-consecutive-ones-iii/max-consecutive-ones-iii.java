class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, n = nums.length, max = 0, numsZeros = 0;
        for(;right<n;right++){
            if(nums[right]==0) numsZeros++;
            if(numsZeros>k){
                if(nums[left]==0)numsZeros--;
                left++;
            }
            if(numsZeros<=k){
                max = Math.max(right-left+1,max);
            }
        }
        return max;
    }
}