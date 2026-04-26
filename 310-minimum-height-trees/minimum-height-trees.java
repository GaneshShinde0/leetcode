class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        ArrayList<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++)
            neighbors.add(new HashSet<Integer>());

        for (int[] edge : edges) {
            Integer start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (neighbors.get(i).size() == 1)
                leaves.add(i);

        // Trim the leaves until reaching the centroids
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            // remove the current leaves along with the edges
            for (Integer leaf : leaves) {
                // the only neighbor left for the leaf node
                Integer neighbor = neighbors.get(leaf).iterator().next();

                // remove the edge along with the leaf node
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
class SolutionInitial {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length==0) return List.of(0);
        int[] degrees = new int[n];
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            degrees[edge[0]]++;
            degrees[edge[1]]++;
            graph.computeIfAbsent(edge[0],x->new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1],x->new HashSet<>()).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degrees[i]==1){
                queue.add(i);
            }
        }
        Set<Integer> removed = new HashSet<>();
        int maxDepth = 0;
        while(!queue.isEmpty()){
            if(graph.size()==2){
                int greaterThanOne = 0;
                for(int key: graph.keySet()){
                    greaterThanOne+=degrees[key];
                }
                if(greaterThanOne<=2) return new ArrayList<>(graph.keySet());
            }
            int size = queue.size();
            for(int i=0;i<size;i++){
                if(graph.size()==1) return new ArrayList<>(graph.keySet());
                int curr = queue.poll();
                for(int neighbor: graph.get(curr)){
                    degrees[neighbor]--;
                    if(degrees[neighbor]==1) queue.add(neighbor);
                    graph.get(neighbor).remove(curr);
                }
                graph.remove(curr);
                degrees[curr]--;
            }
        }
        return new ArrayList<>();
    }
}