import java.util.*;

class Solution {
    private List<List<Integer>> graph;
    private int[] firstMax;   // Longest path downwards from node u
    private int[] secondMax;  // Second longest path downwards from node u
    private int[] maxDist;    // Longest path starting from node u (result equivalent)

    public String findSpecialNodes(int n, int[][] edges) {
        // 1. Build Adjacency List
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // Initialize DP arrays
        firstMax = new int[n];
        secondMax = new int[n];
        maxDist = new int[n];

        // 2. First DFS (Post-order): Compute max depth going DOWN into subtrees
        // We calculate height based on edges (leaf = 0).
        dfsDown(0, -1);

        // 3. Second DFS (Pre-order): Compute max depth considering UPWARD paths (re-rooting)
        // Combine downward info with the path coming from parent.
        dfsUp(0, -1, 0);

        // 4. Find the diameter (maximum value in maxDist)
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

    // Computes the height of the tree rooted at u (considering only children)
    private void dfsDown(int u, int p) {
        for (int v : graph.get(u)) {
            if (v == p) continue;
            
            dfsDown(v, u);
            
            int depth = firstMax[v] + 1; // 1 edge + child's max depth
            
            // Update first and second largest depths
            if (depth > firstMax[u]) {
                secondMax[u] = firstMax[u];
                firstMax[u] = depth;
            } else if (depth > secondMax[u]) {
                secondMax[u] = depth;
            }
        }
    }

    // Computes the longest path for u considering the path coming from parent
    private void dfsUp(int u, int p, int upPath) {
        // The longest path starting at u is either the longest downward path 
        // OR the path coming from the parent (upPath).
        maxDist[u] = Math.max(firstMax[u], upPath);

        for (int v : graph.get(u)) {
            if (v == p) continue;

            // Calculate the longest path 'upwards' for the child v.
            // It is 1 + max(path coming to u from u's parent, 
            //               longest path from u downwards NOT passing through v)
            
            int longestFromU = upPath; // Path from u's parent
            
            if (firstMax[v] + 1 == firstMax[u]) {
                // v is on the longest path of u, so we take the second longest
                longestFromU = Math.max(longestFromU, secondMax[u]);
            } else {
                // v is NOT on the longest path, so we can take the longest
                longestFromU = Math.max(longestFromU, firstMax[u]);
            }

            dfsUp(v, u, longestFromU + 1);
        }
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