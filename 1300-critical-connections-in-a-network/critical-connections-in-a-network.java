/*
We will use DFS.

We will take two separate arrays. (Time of insersion is basically when particular node in DFS was visited)
1. Time of insertion : array
2. Lowest time of insertion of all adjacent nodes apart from parent. : array


*/
class Solution {
    // Print all the bridges.
    // We can use Tarjan's algorithm
    private int timer = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(List<Integer> edge:connections){
            graph.computeIfAbsent(edge.get(0), x->new HashSet<Integer>()).add(edge.get(1));
            graph.computeIfAbsent(edge.get(1), x->new HashSet<Integer>()).add(edge.get(0));
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] toi = new int[n];
        int[] ltoi = new int[n];
        boolean[] vis = new boolean[n];
        dfs(0,-1,toi,ltoi,vis,graph,result);
        return result;
    }
    private void dfs(int node, int parent, int[] toi, int[] ltoi, boolean[] vis, Map<Integer, Set<Integer>> graph, List<List<Integer>> result){
        vis[node] = true;
        toi[node] = ltoi[node] = timer++;
        for(int neighbor: graph.get(node)){
            if(neighbor==parent) continue;
            if(vis[neighbor]){
                ltoi[node] = Math.min(ltoi[node], toi[neighbor]);
            }else{
                dfs(neighbor, node, toi, ltoi, vis, graph, result);
                ltoi[node] = Math.min(ltoi[node], ltoi[neighbor]);
                if(ltoi[neighbor]>toi[node]){
                    result.add(Arrays.asList(neighbor, node));
                }
            }
        }
    }
}