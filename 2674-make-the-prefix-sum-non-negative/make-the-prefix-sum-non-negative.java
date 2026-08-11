class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long currSum = 0;
        int res = 0;
        for(int num:nums){
            currSum+=num;
            if(num<0) pq.add(num);
            while(currSum<0){
                currSum+=-pq.poll();
                res++;
            }
        }
        return res;
    }
}