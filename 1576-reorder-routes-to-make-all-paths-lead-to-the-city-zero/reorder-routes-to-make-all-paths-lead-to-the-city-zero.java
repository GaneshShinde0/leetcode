import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        // Build undirected graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Store original directed edges (start -> end)
        Set<String> directed = new HashSet<>();
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            directed.add(u + "," + v); // mark original direction
        }

        // DFS from node 0
        return dfs(graph, directed, new boolean[n], 0);
    }

    private int dfs(List<List<Integer>> graph, Set<String> directed, boolean[] visited, int node) {
        visited[node] = true;
        int changes = 0;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                // If original edge was node -> next, we are moving forward → needs reversal
                if (directed.contains(node + "," + next)) {
                    changes++;
                }
                changes += dfs(graph, directed, visited, next);
            }
        }

        return changes;
    }

    public int minReorderInitial(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] connection:connections){
            al.get(connection[0]).add(connection[1]);
            al.get(connection[1]).add(-connection[0]);
        }
        // System.out.println(al);
        return dfsInitial(al,new boolean[n],0);
    }
    public int dfsInitial(List<List<Integer>> al, boolean[] visited, int from){
        int change = 0;
        visited[from]=true;
        for(int to:al.get(from)){
            if(!visited[Math.abs(to)]){
                change+=dfsInitial(al,visited,Math.abs(to))+(to>0?1:0);
            }
        }
        return change;
    }
}