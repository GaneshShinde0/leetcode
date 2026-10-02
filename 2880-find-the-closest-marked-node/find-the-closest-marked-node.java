class Solution {

    public int minimumDistance(
        int n,
        List<List<Integer>> edges,
        int s,
        int[] marked
    ) {
        // Adjacency list representation
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            int weight = edge.get(2);
            graph.get(from).add(new int[] { to, weight });
        }

        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        // Track nodes in queue
        boolean[] inQueue = new boolean[n];
        inQueue[s] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            inQueue[current] = false;

            // Explore neighbors
            for (int[] next : graph.get(current)) {
                int nextNode = next[0];
                int weight = next[1];

                // Relaxation step
                if (dist[nextNode] > dist[current] + weight) {
                    dist[nextNode] = dist[current] + weight;

                    // Add to queue if not already in queue
                    if (!inQueue[nextNode]) {
                        queue.offer(nextNode);
                        inQueue[nextNode] = true;
                    }
                }
            }
        }

        // Find minimum distance to any marked node
        int minDist = Integer.MAX_VALUE;
        for (int node : marked) {
            minDist = Math.min(minDist, dist[node]);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}