class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            res = Math.max(res,sum);
            if(sum<0) sum = 0;
        }
        return res;
    }
}