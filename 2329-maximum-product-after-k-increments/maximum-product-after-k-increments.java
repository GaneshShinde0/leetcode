class Solution {
    private final int MOD = 1_000_000_007;
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums) pq.add(i);
        while(k>0){
            pq.add(pq.poll()+1); // Can optimize here by how k will get modified but not worried about it as k is small enough
            k--;
        }
        long product = 1;
        while(!pq.isEmpty()){
            product = (1l*product*pq.poll())%MOD;
        }
        return (int) product;
    }
}