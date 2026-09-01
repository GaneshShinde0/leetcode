class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, res = 0;
        if(n<2) return n;
        int up = 1,down = 1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                up = down+1;
            }else if(nums[i]<nums[i-1]){
                down = up+1;
            }
        }
        return Math.max(down, up);
    }
    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int prevDiff = 0, res = 1;
        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >= 0)) {
                res++;
                prevDiff = diff;
            }
        }
        return res;
    }
}