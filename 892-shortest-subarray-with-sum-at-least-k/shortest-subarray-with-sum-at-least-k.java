class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, res = Integer.MAX_VALUE;
        int[] prefixSum = new int[n+1];
        for(int i=0;i<n;i++){
            prefixSum[i+1] = prefixSum[i]+nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<=n;i++){
            while(!deque.isEmpty() && prefixSum[i]-prefixSum[deque.peekFirst()]>=k){
                res = Math.min(res, i-deque.pollFirst());
            }
            while(!deque.isEmpty() && prefixSum[i]<=prefixSum[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}