class Solution {
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