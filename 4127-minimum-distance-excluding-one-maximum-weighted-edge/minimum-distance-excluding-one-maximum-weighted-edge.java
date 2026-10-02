class Solution {
    private static final class Node {
        private final int index, excluded;
        private final long time;
        private Node(int index, int excluded, long time) {
            this.index = index;
            this.excluded = excluded;
            this.time = time;
        }
    }
    public long minCostExcludingMax(int n, int[][] edges) {
        int[][][] adj = buildGraph(n, edges);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        long[][] dist = new long[3][n];
        Arrays.fill(dist[0], Long.MAX_VALUE);
        Arrays.fill(dist[1], Long.MAX_VALUE);
        dist[0][0] = dist[1][0] = 0;
        pq.offer(new Node(0, 0, 0));
        while(true) {
            Node current = pq.poll();
            int index = current.index, excluded = current.excluded;
            long time = current.time;
            if(dist[excluded][index] < time) continue;
            if(index == n - 1) return time;
            for(int[] next : adj[index]) {
                int nextIndex = next[0];
                long nextTime = time + next[1];
                if(time < dist[excluded + 1][nextIndex]) {
                    dist[excluded + 1][nextIndex] = time;
                    pq.offer(new Node(nextIndex, excluded + 1, time));
                }
                if(nextTime < dist[excluded][nextIndex]) {
                    dist[excluded][nextIndex] = nextTime;
                    pq.offer(new Node(nextIndex, excluded, nextTime));
                }
            }
        }
    }
    private static int[][][] buildGraph(int n, int[][] edges) {
        int[] degree = new int[n];
        for(int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        int[][][] adj = new int[n][][];
        for(int i = 0; i < n; i++) adj[i] = new int[degree[i]][];
        for(int[] edge : edges) {
            int a = edge[0], b = edge[1], c = edge[2];
            adj[a][--degree[a]] = new int[] {b, c};
            adj[b][--degree[b]] = new int[] {a, c};
        }
        return adj;
    }
}