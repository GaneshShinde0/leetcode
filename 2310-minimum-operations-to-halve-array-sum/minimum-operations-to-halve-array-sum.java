class Solution {
    public int halveArray(int[] nums) {
        double sum =0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            sum+=i;
            pq.offer(i*1.0);
        }
        double half = sum/2;
        int res = 0;
        while(sum>half){
            double drop = pq.poll();
            pq.add(drop/2);
            sum-=drop/2;
            res++;
        }
        return res;
    }
}