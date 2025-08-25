class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(graph,0, path, result);
        return result;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result){
        // If we reach the last node, add the path to the result.
        if(node == graph.length-1){
            result.add(new ArrayList<>(path));
            return;
        }

        // Explore neighbors
        for(int neighbor:graph[node]){
            path.add(neighbor); // Choose
            dfs(graph, neighbor, path, result); // Explore
            path.remove(path.size()-1);
        }
    }
}