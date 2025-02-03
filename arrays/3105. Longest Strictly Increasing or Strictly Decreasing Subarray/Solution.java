class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int temp = 1;
        int temp2=1;
        int res = 1;

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) temp++;
            else temp =1;
            if(nums[i]<nums[i+1]) temp2++;
            else temp2=1;
            res = Math.max(res,Math.max(temp, temp2));
        }
        return res;
    }
}
