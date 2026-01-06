class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        HashMap<Integer, List<Pair<Integer,Integer>>> hm = new HashMap<>();
        for(int[] time:times){
            hm.computeIfAbsent(time[0],z->new ArrayList<Pair<Integer,Integer>>()).add(new Pair(time[1],time[2]));
        }
        dijkstra(dist,k,n,hm);
        int maxDist = 0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            maxDist = Math.max(maxDist,dist[i]);
        }
        return maxDist;
    }

    private void dijkstra(int[] dist,int k, int n,HashMap<Integer, List<Pair<Integer,Integer>>> hm){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{k,0}); // Lets start with one node;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0], weight = curr[1];
            if(weight>dist[node]) continue;
            if(!hm.containsKey(node)) continue;
            for(Pair<Integer,Integer> edge:hm.get(node)){
                int neighbor = edge.getKey();
                int time = edge.getValue();
                if(dist[neighbor]>weight+time){
                    dist[neighbor] = weight+time;
                    pq.add(new int[]{neighbor,dist[neighbor]});
                }
            }
        }
    }
}