class Solution {
    
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length, res = 0;
        int[] diff = new int[n];
        for(int i=0;i<n;i++){
            diff[i] = capacity[i]-rocks[i];
        }
        Arrays.sort(diff);
        for(int i=0;i<n;i++){
            if(additionalRocks>=diff[i]){
                additionalRocks-=diff[i];
                res++;
            }else{
                break;
            }
        }
        
        return res;
    }
    public int maximumBagsUsingPQAddsOverhead(int[] capacity, int[] rocks, int additionalRocks) {
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