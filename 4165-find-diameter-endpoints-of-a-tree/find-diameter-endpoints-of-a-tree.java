import java.util.*;

class Solution1 {
    private List<List<Integer>> graph;
    private int[] firstMax;   // Longest path downwards from node u
    private int[] secondMax;  // Second longest path downwards from node u
    private int[] maxDist;    // Longest path starting from node u (result equivalent)

    public String findSpecialNodes(int n, int[][] edges) {
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        firstMax = new int[n];
        secondMax = new int[n];
        maxDist = new int[n];

        dfsDown(0, -1);
        dfsUp(0, -1, 0);

        int diameter = 0;
        for (int d : maxDist) {
            diameter = Math.max(diameter, d);
        }

        // 5. Build the binary string
        StringBuilder sb = new StringBuilder(n);
        for (int d : maxDist) {
            sb.append(d == diameter ? '1' : '0');
        }

        return sb.toString();
    }

    private void dfsDown(int u, int p) {
        for (int v : graph.get(u)) {
            if (v == p) continue;
            
            dfsDown(v, u);
            int depth = firstMax[v] + 1;
            if (depth > firstMax[u]) {
                secondMax[u] = firstMax[u];
                firstMax[u] = depth;
            } else if (depth > secondMax[u]) {
                secondMax[u] = depth;
            }
        }
    }

    private void dfsUp(int u, int p, int upPath) {
        maxDist[u] = Math.max(firstMax[u], upPath);
        for (int v : graph.get(u)) {
            if (v == p) continue;
            int longestFromU = upPath;
            if (firstMax[v] + 1 == firstMax[u]) {
                longestFromU = Math.max(longestFromU, secondMax[u]);
            } else {
                longestFromU = Math.max(longestFromU, firstMax[u]);
            }

            dfsUp(v, u, longestFromU + 1);
        }
    }
}

/* Solution 2
Intuition:

Find all the furthest nodes from node 0, as they all must be the endpoints. Then pick any of these endpoints and find all the furthest nodes from that, as these must be the opposite endpoints.

Complexity:
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution{
    private int[][] adj;
    private int[] dist;
    private int max = 0; // Global max depth for any node;

    public String findSpecialNodes(int n, int[][] edges){
        this.adj = buildGraph(edges, n); // Optimized adj list function.
        this.dist = new int[n];
        char[] arr = new char[n];
        calcDepth(0,-1,1); // Find distance from node 0;
        int index = -1;
        for(int i=0;i<n;i++){
            if(dist[i]==max){ // If a node is max from 0 then it must be an endpoint.
                index = i;
                arr[i]='1';
            }else{
                arr[i]='0';
            }
            dist[i]=0; // Reset the distance array.
        }
        max = 0; // Reset the global max
        calcDepth(index,-1,1); // We have already calculated for startNode 0, now lets count for last Node which  is index.
        for(int i=0;i<n;i++){
            if(dist[i]==max) arr[i] = '1';
        }
        return String.valueOf(arr);
        
    }

    private void calcDepth(int startNode, int prevNode, int depth){
        if(depth>max) max = depth;
        dist[startNode] = depth;
        for(int next: adj[startNode]){
            if(next!=prevNode) calcDepth(next,startNode, depth+1);
        }
    }
    private static int[][] buildGraph(int[][] edges, int n){
        int[] degree = new int[n];
        for(int[] edge:edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        int[][] graph = new int[n][];
        for(int i=0;i<n;i++) graph[i] = new int[degree[i]]; // Optimized Space
        for(int[] edge:edges){
            int u = edge[0], v = edge[1];
            degree[u]--;
            degree[v]--;
            graph[u][degree[u]] = v;
            graph[v][degree[v]] = u;
        }
        return graph;
    }
}
/*

1->5
3-2-5
4-0-5-1
    |
    2
    |
    3
*/