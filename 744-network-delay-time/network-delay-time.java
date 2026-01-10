/*
Minimum time... 
Weights are different... Positive Weights... Directed Graph.
Dijkstras Algorithm.
*/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<List<Integer>>> adj = new HashMap<>();
        for(int[] time:times){
            List<List<Integer>> subList = adj.computeIfAbsent(time[0], t -> new ArrayList<>());
            List<Integer> li = new ArrayList<>();
            li.add(time[1]);
            li.add(time[2]);
            subList.add(li);
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkstra(k,dist,adj);
        
        int res = 0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            res = Math.max(res,dist[i]);
        }
        return res;
    }

    private void dijkstra(int start, int[] dist, Map<Integer,List<List<Integer>>> adj){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{start,0});
        boolean[] visited = new boolean[dist.length+1];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];
            if(!adj.containsKey(node)) continue;
            if(dist[node]<distance) continue;
            if(visited[node]) continue;
            dist[node]=distance;
            for(List<Integer> edge:adj.get(node)){
                int subNode = edge.get(0);
                int subDist = edge.get(1);
                // if(dist[subNode]>distance+subDist){
                    dist[subNode] = Math.min(dist[subNode],distance+subDist);
                    pq.add(new int[]{subNode,dist[subNode]});
                // }
            }
            visited[node]=true;
        }
    }
}