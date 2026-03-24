class Solution {
    public List<Integer> eventualSafeNodesInitial(int[][] graph) {
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

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] outDegree = new int[n+1];
        HashMap<Integer, Set<Integer>> adjListChildToParent= new HashMap<>();
        for(int i=0;i<graph.length;i++){
            if(graph[i].length==0) queue.add(i);
            for(int j:graph[i]){
                outDegree[i]++;
                adjListChildToParent.computeIfAbsent(j,k->new HashSet<Integer>()).add(i);
            }
        }
        int[] resultArr = new int[n+1];
        while(!queue.isEmpty()){
            int curr = queue.poll();
            resultArr[curr]=1;
            if(!adjListChildToParent.containsKey(curr)) continue;
            for(int parent: adjListChildToParent.get(curr)){
                if(outDegree[parent]>0){
                    outDegree[parent]--;
                    if(outDegree[parent]==0) queue.add(parent);
                }
            }
        }
        for(int i=0;i<=n;i++){
            if(resultArr[i]==1) result.add(i);
        }
        // Collections.sort(result);
        // return new ArrayList<Integer>(result);
        return result;
    }
}