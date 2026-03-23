class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Set<Integer>> adjList= new HashMap<>();
        HashMap<Integer, Set<Integer>> adjListChildToParent= new HashMap<>();
        for(int i=0;i<graph.length;i++){
            if(graph[i].length==0) queue.add(i);
            for(int j:graph[i]){
                adjList.computeIfAbsent(i,k->new HashSet<Integer>()).add(j);
                adjListChildToParent.computeIfAbsent(j,k->new HashSet<Integer>()).add(i);
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result.add(curr);
            if(!adjListChildToParent.containsKey(curr)) continue;
            for(int parent: adjListChildToParent.get(curr)){
                if(adjList.containsKey(parent)){
                    adjList.get(parent).remove(curr);
                    if(adjList.get(parent).size()==0) queue.add(parent);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}