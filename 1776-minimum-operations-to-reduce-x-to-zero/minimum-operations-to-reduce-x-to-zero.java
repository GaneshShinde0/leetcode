class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0, n = nums.length;
        for(int num:nums) sum+= num;
        int longestSubArr = longestSubArrayLength(nums,sum-x);
        if(longestSubArr==-1) return -1;
        return nums.length-longestSubArr;
    }
    private int longestSubArrayLength(int[] nums, int target){
        int left = 0, right = 0, n= nums.length, sum = 0, res = -1;
        while(right<n){
            sum+=nums[right];
            while(left<=right && sum>target){
                sum-=nums[left];
                left++;
            }
            if(sum==target)res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}