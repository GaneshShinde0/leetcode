class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        int len = nums.length;
        for(int i=0;i<=nums.length/2;i++){
            if (max<nums[i]+nums[len-i-1]) max = nums[i]+nums[len-i-1];
        }
        return max;
    }
}