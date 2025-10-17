class Solution {
    // Initial Solution 30 Min
    public int connectSticksInitial(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:sticks){
            pq.add(i);
        }
        List<Integer> li = new ArrayList<>();
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            pq.add(x+y);
            li.add(x+y);
        }
        int res = 0;
        for(int i:li){
            res+=i;
        }
        return res;
    }
    // Optimized
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:sticks){
            pq.add(i);
        }
        int res = 0;
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            pq.add(x+y);
            res+=(x+y);
        }
        return res;
    }
}