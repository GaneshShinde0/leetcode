class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = capacity.length, res = 0;
        for(int i=0;i<n;i++){
            if(capacity[i]>rocks[i]){
                pq.add(capacity[i]-rocks[i]);
            }else{
                res++;
            }
        }
        // System.out.println(pq);
        while(!pq.isEmpty() && pq.peek()<=additionalRocks){
            res++;
            additionalRocks-=pq.poll();
        }
        return res;
    }
}