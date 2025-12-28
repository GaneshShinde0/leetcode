class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        long res = Integer.MIN_VALUE, curr = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            res = Math.max(res, prefixSum[i]-curr);
            curr = Math.min(nums[i],curr);
        }
        return res;
    }
}