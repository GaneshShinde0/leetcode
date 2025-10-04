class Solution {
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     HashMap<Integer, TreeSet<Integer>> hm = new HashMap<>();
    //     for(int[] p:prerequisites){
    //         hm.computeIfAbsent(p[0],k-> new TreeSet<>()).add(p[1]);
    //         TreeSet<Integer> ts = hm.get(p[0]);
    //         ts.addAll(hm.getOrDefault(p[1],new TreeSet<>()));
    //         System.out.println(ts);
    //         if(hm.containsKey(p[1])&&hm.get(p[1]).contains(p[0])) return false;
    //     }
    //     return true;
    // }

    public boolean canFinishInitial(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<Integer>());

        for(int[] p:prerequisites){
            // You must take course bi to complete ai
            // So there is direction from bi->ai (as b needs to be completed first otherwise we cant reach a)
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
        }

        int count = 0; // We can track processed nodes.
        while(!q.isEmpty()){
            int curr = q.remove();
            count++;
            for(int conn: adj.get(curr)){
                indegree[conn]--;
                if(indegree[conn]==0) q.add(conn);
            }
        }
        return count == n;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] p:prerequisites){
            adj.get(p[0]).add(p[1]);
        }
        Set<Integer> visitSet = new HashSet<>();
        for(int course =0;course<n;course++){
            if(!dfs(visitSet,adj,course)) return false;
        }
        return true;
    }

    private boolean dfs(Set<Integer> visitSet,List<List<Integer>> adj, int course){
        if(visitSet.contains(course)) return false;
        if(adj.get(course).size()==0) return true;
        visitSet.add(course);
        for(int pre:adj.get(course)){
            if(!dfs(visitSet,adj,pre))return false;
        }
        visitSet.remove(course);
        adj.set(course,new ArrayList<>());
        return true;
    }
}