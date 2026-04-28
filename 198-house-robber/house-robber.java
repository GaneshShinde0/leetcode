class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int t1 = nums[0], t2 = Math.max(nums[1],nums[0]);
        for(int i=2;i<nums.length;i++){
            int temp = t2;
            t2 = Math.max(t1+nums[i],t2);
            t1 = temp;
        }   
        return Math.max(t2,t1);
    }
}