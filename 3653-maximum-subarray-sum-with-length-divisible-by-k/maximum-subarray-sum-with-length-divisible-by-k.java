/*
nums = [-1,-2,-3,-4,-5]
sum = 0
res = Min
n = 5

i = 3
sum = -10
hm = {0,-1}, {1,-3}, {2,-6}, {3,-10}


i = 4
sum = -14
hm = {0,-1}, {1,-3}, {2,-6}, {3,-10},
res = -1-14

*/
class Solution {
    public long maxSubarraySumDoesNotWork470Of661(int[] nums, int k) {
        long sum = 0;
        long res = Integer.MIN_VALUE;
        int n = nums.length;
        HashMap<Integer,Long> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(i>=k-1){
                if(i-k>=0)sum-=nums[i-k];
                res = Math.max(hm.getOrDefault(i-k,0l)+sum,res);
                res = Math.max(sum,res);
                hm.put(i, res);
            }else{
                hm.put(i,sum);
            }
        }
        return res;
    }
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;
        long[] kSum = new long[k];
        Arrays.fill(kSum,Long.MAX_VALUE/2);
        
        kSum[k-1] = 0;
        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum-kSum[i%k]);
            kSum[i%k] = Math.min(kSum[i%k],prefixSum);
        }
        return maxSum;
    }
}