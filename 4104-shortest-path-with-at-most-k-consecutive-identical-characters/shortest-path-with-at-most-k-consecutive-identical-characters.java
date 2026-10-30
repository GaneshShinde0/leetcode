class Solution {
    String labels;
    int k;
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if(n==1) return 0;
        this.labels = labels;
        this.k=k;
        Map<Integer,List<List<Integer>>> adj = new HashMap<>();
        for(int[] edge:edges){
            List<List<Integer>> subList = adj.computeIfAbsent(edge[0], t -> new ArrayList<>());
            List<Integer> li = new ArrayList<>();
            li.add(edge[1]);
            li.add(edge[2]);
            subList.add(li);
        }
        long[][] dist = new long[n][k + 1];
        for(long[] row : dist) Arrays.fill(row, Long.MAX_VALUE);
        dijkstra(0,dist,adj);

        long ans = Long.MAX_VALUE;
        for(int f = 1; f <= k; f++){
            ans = Math.min(ans, dist[n-1][f]);
        }
        return ans == Long.MAX_VALUE ? -1 : (int)ans;
    }

    private void dijkstra(int start, long[][] dist, Map<Integer,List<List<Integer>>> adj){
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        dist[start][1] = 0;
        pq.add(new long[]{start,0,labels.charAt(0),1});
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long distance = curr[1];
            long lastChar  = curr[2];
            long lastFreq = curr[3];
            if(!adj.containsKey(node)) continue;
            if(distance > dist[node][(int)lastFreq]) continue;
            for(List<Integer> edge:adj.get(node)){
                int subNode = (int) edge.get(0);
                long subDist = edge.get(1);
                if(distance + subDist < distance){
                    System.out.println(
                    "distance=" + distance +
                    " subDist=" + subDist +
                    " sum=" + (distance + subDist)
                ); 
                }
                              
                long currChar = (long) labels.charAt(subNode);
                long currK = (currChar!=lastChar)?1:lastFreq+1;
                if(currK>k) continue;
                // if(dist[subNode]>distance+subDist){// (If we use visited then we dont need this.) and vice versa
                //     dist[subNode] = distance+subDist;
                //     pq.add(new long[]{subNode,dist[subNode],currChar,currK});
                // }
                if(dist[subNode][(int)currK] > distance + subDist){
                    dist[subNode][(int)currK] = distance + subDist;
                    pq.add(new long[]{subNode, distance + subDist, currChar, currK});
                }
            }
        }
    }
}