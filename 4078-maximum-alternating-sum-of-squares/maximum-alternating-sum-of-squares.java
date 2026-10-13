class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int n = nums.length;
        long sum1 = 0, sum2 = 0;
        for(int i=0;i<n;i++){
            if(i<n/2) sum2 += nums[i]*nums[i];
            else sum1 += nums[i]*nums[i];
        }
        return sum1-sum2;
    }
}