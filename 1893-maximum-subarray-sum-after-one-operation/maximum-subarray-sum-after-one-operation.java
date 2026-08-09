class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = 0;
        for(int i=1;i<n;i++){
            maxLeft[i] = Math.max(maxLeft[i-1]+nums[i-1],0);
        }
        maxRight[n-1] = 0;
        for(int i = n-2; i>=0; i--){
            maxRight[i] = Math.max(maxRight[i+1]+nums[i+1],0);
        }
        int maxSum = 0;
        for(int i=0;i<n;i++){
            maxSum = Math.max(maxSum, maxLeft[i]+nums[i]*nums[i]+maxRight[i]);
        }
        return maxSum;
    }
}