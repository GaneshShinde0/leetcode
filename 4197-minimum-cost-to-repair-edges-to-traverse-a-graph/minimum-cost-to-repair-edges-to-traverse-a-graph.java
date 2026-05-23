class Solution {
    public int minCost(int n, int[][] edges, int k) {
        Map<Integer, Set<int[]>> adj = new HashMap<>();
        for(int[] edge:edges){
            adj.computeIfAbsent(edge[0],t->new HashSet<>()).add(new int[]{edge[1],edge[2]});
            adj.computeIfAbsent(edge[1],t->new HashSet<>()).add(new int[]{edge[0],edge[2]});
        }
        // If we do not have start in edges then return -1;
        if(!adj.containsKey(0)) return -1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        int[] minEdges = new int[n];
        Arrays.fill(minEdges, Integer.MAX_VALUE);
        queue.add(new int[]{0,0,0});
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int node = curr[0];
            int costOfRepair  = curr[1];
            if (node == n - 1) return costOfRepair;
            if (curr[2] >= minEdges[node]) continue;
            minEdges[node] = curr[2];
            for(int[] edge:adj.get(node)){
                int maxInPath = Math.max(edge[1],costOfRepair);
                if(curr[2]<k) queue.offer(new int[]{edge[0],maxInPath,curr[2]+1});
            }
        }
        return -1;
    }
}