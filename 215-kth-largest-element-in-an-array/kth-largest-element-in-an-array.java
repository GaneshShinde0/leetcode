class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i:nums){
            pq.offer(i);
        }
        for(int i=0;i<nums.length-k;i++){
            pq.poll();
        }
        System.out.println(pq);
        return pq.peek();
    }
}