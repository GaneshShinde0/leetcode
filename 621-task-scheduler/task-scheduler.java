class Solution {
    public int leastIntervalInitial(char[] tasks, int n) {
        int currGap = n;
        int[] freq = new int[26];
        for(char c:tasks) freq[c-'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:freq){
            if(i>0) pq.offer(i);
        }
        int time = 0;
        while(!pq.isEmpty()){
            int cycle = n+1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            while(cycle-->0 && !pq.isEmpty()){
                int currFreq = pq.poll();
                if(currFreq>1){
                    store.add(currFreq-1);
                }
                taskCount++;
            }
            store.forEach(pq::offer);
            time += (pq.isEmpty()?taskCount:n+1);
        }
        return time;
    }

    
    public int leastInterval(char[] tasks, int n) {
        int currGap = n;
        int[] freq = new int[26];
        for(char c:tasks) freq[c-'A']++;
        Arrays.sort(freq);
        int res = (freq[25]-1)*n;
        for(int i=24;i>=0;i--){
            res -= Math.min((freq[25]-1),freq[i]);
        }
        return res>0?res+tasks.length:tasks.length;

    }
}