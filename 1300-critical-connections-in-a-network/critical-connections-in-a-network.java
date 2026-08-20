/*
We will use DFS.

We will take two separate arrays. (Time of insersion is basically when particular node in DFS was visited)
1. Time of insertion : array
2. Lowest time of insertion of all adjacent nodes apart from parent. : array


*/
class SolutionReursive{
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
                ltoi[node] = Math.min(ltoi[node], ltoi[neighbor]);
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

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : connections) {
            graph.computeIfAbsent(edge.get(0), x -> new ArrayList<>()).add(edge.get(1));
            graph.computeIfAbsent(edge.get(1), x -> new ArrayList<>()).add(edge.get(0));
        }

        int[] toi = new int[n];
        int[] ltoi = new int[n];
        int[] parent = new int[n];
        int[] iterIndex = new int[n]; // remembers which neighbor index we were at for each node
        Arrays.fill(toi, -1);
        Arrays.fill(parent, -2);

        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int timer = 0;

        stack.push(0);
        parent[0] = -1;
        toi[0] = ltoi[0] = timer++;

        while (!stack.isEmpty()) {
            int node = stack.peek();
            List<Integer> neighbors = graph.getOrDefault(node, Collections.emptyList());

            if (iterIndex[node] < neighbors.size()) {
                int neighbor = neighbors.get(iterIndex[node]++);
                if (neighbor == parent[node]) continue; // skip parent edge

                if (toi[neighbor] == -1) {
                    // tree edge -> "recurse"
                    parent[neighbor] = node;
                    toi[neighbor] = ltoi[neighbor] = timer++;
                    stack.push(neighbor);
                } else {
                    // back edge
                    ltoi[node] = Math.min(ltoi[node], toi[neighbor]);
                }
            } else {
                // finished this node -> simulate "returning" to parent
                stack.pop();
                int p = parent[node];
                if (p != -1) {
                    ltoi[p] = Math.min(ltoi[p], ltoi[node]);
                    if (ltoi[node] > toi[p]) {
                        result.add(Arrays.asList(p, node));
                    }
                }
            }
        }
        return result;
    }
}