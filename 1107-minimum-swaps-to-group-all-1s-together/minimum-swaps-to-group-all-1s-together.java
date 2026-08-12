class Solution {
    public int minSwaps(int[] nums) {
        if(nums.length<=2) return 0;
        int n = 0;
        for(int num:nums) if(num==1) n++;
        int left = 0, right = 0, max = 0, curr = 0;
        while(right<nums.length){
            while(right<nums.length && (right-left)<n){
                if(nums[right]==1){
                    curr++;
                }
                right++;
            }
            max = Math.max(curr,max);
            if(right == nums.length) break;
            if(nums[left]==1){
                curr--;
            }
            left++;
        }
        return n-max;
    }
}