class Solution {
    public int convertArray(int[] nums) {
        int costNonDecreasing = getMinCostNonDecreasing(nums);
        int[] negativeNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            negativeNums[i] = -nums[i];
        int costNonIncreasing = getMinCostNonDecreasing(negativeNums);
        return Math.min(costNonDecreasing, costNonIncreasing);
    }

    private int getMinCostNonDecreasing(int[] arr){
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:arr){
            pq.offer(num);
            if(pq.peek()<num){
                cost += (num-pq.poll());
                pq.offer(num);
            }
        }
        return cost;
    }
}