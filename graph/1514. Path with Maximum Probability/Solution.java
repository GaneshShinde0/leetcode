/*
# Problem 1514. Path with Maximum Probability

## Description:
- Given an undirected weighted graph with `n` nodes, represented by an edge list where `edges[i] = [a,b]` and `succProb[i]` represents the probability of successfully traversing from node `a` to node `b`.
- You need to find the maximum probability of success in going from the start node to the end node.
- If there is no path from the start to the end node, return 0.

## Approach:

### Approach 1: Bellman-Ford Algorithm
- **Bellman-Ford Algorithm** is used to find the shortest path in graphs with weighted edges. Here, we modify it to find the maximum probability path.
- **Relaxation**: Update the maximum probability to reach each node iteratively for up to `n-1` times.
- **Steps**:
  1. Initialize the probability for the starting node to 1.0 and all others to 0.
  2. Iterate over the edges and update the maximum probability for each node by considering all possible paths.
  3. Stop early if no further updates are made in an iteration.

### Approach 2: Dijkstra's Algorithm (Max-Heap Variant)
- **Dijkstra’s Algorithm** can be adapted for this problem by using a max-heap to maintain the nodes with the highest probability.
- **Steps**:
  1. Use a priority queue (max-heap) where the priority is the probability of reaching a node.
  2. Initialize the start node with probability 1.0 and other nodes with 0.
  3. Continuously extract the node with the highest probability from the heap and update its neighbors.
  4. Stop when you reach the end node or the heap is empty.

### Key Points:
- **Relaxation**: Ensures that the best probability path to each node is considered.
- **Early Stopping**: Helps to optimize performance by breaking early if no updates are possible.
- **Complexity**: 
  - **Bellman-Ford**: `O(E * n)` where `E` is the number of edges and `n` is the number of nodes.
  - **Dijkstra’s Algorithm**: `O(E log V)` where `V` is the number of vertices.

*/
class Solution {
    // ### Approach 1: Bellman-Ford Algorithm
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        // Relax edges up to n-1 times
        for (int i = 0; i < n - 1; i++) {
            boolean hasUpdate = false;

            // Iterate through all edges
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double pathProb = succProb[j];

                // Update maximum probability for both directions of the edge
                if (maxProb[u] * pathProb > maxProb[v]) {
                    maxProb[v] = maxProb[u] * pathProb;
                    hasUpdate = true;
                }
                if (maxProb[v] * pathProb > maxProb[u]) {
                    maxProb[u] = maxProb[v] * pathProb;
                    hasUpdate = true;
                }
            }

            // If no updates were made, we can stop early
            if (!hasUpdate) {
                break;
            }
        }

        return maxProb[end];
    }

    //### Approach 2: Dijkstra's Algorithm (Max-Heap Variant)
    public double maxProbabilityDijkstra(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create adjacency list
        List<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(new double[]{edges[i][1], succProb[i]});
            graph[edges[i][1]].add(new double[]{edges[i][0], succProb[i]});
        }

        // Max-Heap with probability and node
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        double[] maxProb = new double[n];
        Arrays.fill(maxProb, 0.0);
        maxProb[start] = 1.0;
        maxHeap.add(new double[]{start, 1.0});

        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int node = (int) top[0];
            double prob = top[1];

            if (node == end) {
                return prob;
            }

            for (double[] edge : graph[node]) {
                int neighbor = (int) edge[0];
                double edgeProb = edge[1];
                double newProb = prob * edgeProb;
                if (newProb > maxProb[neighbor]) {
                    maxProb[neighbor] = newProb;
                    maxHeap.add(new double[]{neighbor, newProb});
                }
            }
        }

        return 0.0;
    }
}
