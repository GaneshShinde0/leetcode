class Solution {
    public int twoSumLessThanK1(int[] nums, int k) {
        int res = -1;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])<k&& (nums[i]+nums[j])>res ){
                    res = nums[i]+nums[j];
                }
            }
        }
        return res;
    }
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int res = Integer.MIN_VALUE;
        while (r > l) {
            if (nums[l] + nums[r] >= k) {
                r--;
            } else {
                res = Math.max(res, nums[l] + nums[r]);
                l++;
            }
        }
        
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}