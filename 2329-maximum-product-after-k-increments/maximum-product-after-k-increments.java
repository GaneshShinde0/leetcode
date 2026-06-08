class Solution {
    private final int MOD = 1_000_000_007;
    
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(nums.length==1) return nums[0]+k;
        for(int i:nums) pq.add(i);
        while(k>0){
            int num1 = pq.poll();
            int num2 = pq.peek();
            int diff = Math.min(k,num2-num1+1);
            k-=diff;
            pq.add(num1+diff);
        }
        long product = 1;
        while(!pq.isEmpty()){
            product = (1l*product*pq.poll())%MOD;
        }
        return (int) product;
    }
    public int maximumProductInitial(int[] nums, int k) {
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