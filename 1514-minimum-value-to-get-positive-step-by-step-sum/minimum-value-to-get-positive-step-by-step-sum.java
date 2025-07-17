class Solution {
    public int minStartValue(int[] nums) {
        int sum = nums[0];
        int res = Math.min(nums[0],1);
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            res = Math.min(res,sum);
        }
        return res<=0?(res*-1+1):res;
    }
}