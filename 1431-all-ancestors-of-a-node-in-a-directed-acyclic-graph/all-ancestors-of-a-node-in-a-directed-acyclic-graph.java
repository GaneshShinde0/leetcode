class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i,new HashSet<Integer>());
        int[] inDegree = new int[n];
        for(int[] edge:edges){
            adj.computeIfAbsent(edge[0],k->new HashSet<>()).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList();
        List<Integer> topologicalOrder = new ArrayList<>();
        for(int i=0;i<n;i++) if(inDegree[i]==0) queue.add(i);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            topologicalOrder.add(curr);
            for(int neighbor:adj.get(curr)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.add(neighbor);
                }
            }
        }

        // Initialize the result list and set list for storing ancestors
        List<List<Integer>> ancestorsList = new ArrayList<>();
        List<Set<Integer>> ancestorsSetList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestorsList.add(new ArrayList<>());
            ancestorsSetList.add(new HashSet<>());
        }

        for(int node:topologicalOrder){
            for(int neighbor:adj.get(node)){
                ancestorsSetList.get(neighbor).add(node);
                ancestorsSetList.get(neighbor).addAll(ancestorsSetList.get(node));
            }
        }
        // Convert Sets to Lists
        for(int i=0;i<n;i++){
            for(int node =0;node<n;node++){
                if(node==i) continue;
                if (ancestorsSetList.get(i).contains(node)) {
                    ancestorsList.get(i).add(node);
                }
            }
        }
        return ancestorsList;
    }
}