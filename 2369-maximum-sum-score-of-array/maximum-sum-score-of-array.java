class Solution {
    public long maximumSumScore(int[] nums) {
        int n = nums.length;
        long prefixSum = 0, suffixSum = 0;
        long[] temp = new long[n];
        long res = Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            prefixSum +=nums[i];
            temp[i] = prefixSum;
            res = Math.max(res ,prefixSum);
        }
        for(int i=n-1;i>=0;i--){
            suffixSum+=nums[i];
            res = Math.max(res ,suffixSum);
        }
        return res;
    }
}