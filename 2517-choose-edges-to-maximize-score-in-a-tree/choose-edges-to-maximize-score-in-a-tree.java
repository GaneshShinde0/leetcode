class Solution{
    private List<int[]>[] tree;

    public long maxScore(int[][] edges){
        int n = edges.length;
        tree = new List[n];
        for(int i=0;i<n;i++) tree[i]=new ArrayList<>();
        
        int root = 0;
        for(int i=0;i<n;i++){
            int parent = edges[i][0], weight = edges[i][1];
            if(parent==-1){
                root = i;
            }else{
                tree[parent].add(new int[]{i, weight});
            }
        }
        return dfs(root)[0];
    }

    private long[] dfs(int node){
        long sumChildren = 0, bestGain = 0; // Asume node picks no edge to any child, best iprovement from picking exactly one child edge.

        for(int[] edge: tree[node]){
            int child = edge[0], weight = edge[1];
            long[] res = dfs(child);
            sumChildren += res[0];
            bestGain = Math.max(bestGain, res[1]+weight-res[0]);
        }
        long withoutParentEdge = sumChildren + Math.max(bestGain, 0); // node free to pick one child edge, or none
        long withParentEdge = sumChildren;                            // node already used its one edge, must skip all children edges

        return new long[]{withoutParentEdge, withParentEdge};
    }
}
class SolutionInitial{
    public long maxScore(int[][] edges) {
        int root = 0, n = edges.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(i,new ArrayList<>());
            if(edges[i][0]>=0){
                map.get(edges[i][0]).add(new int[]{i, edges[i][1]});
            }else{
                root = i;
            }
        }
        return dfs(0, root, map, new Long[n][2]);
    }

    private long dfs(int mode, int curr, Map<Integer, List<int[]>> map, Long[][] memo){
        if(memo[curr][mode]!=null) return memo[curr][mode];
        long skip = 0, take = 0;
        // Baseline: curr picks no edge to any child.
        // Sum dfs(0, child) for every child (each child's edge to its own parent is also unused).
        for(int[] m: map.get(curr)){
            skip += dfs(0, m[0], map, memo);
        }
        if(mode == 0){
            for(int[] m:map.get(curr)){
                // Try selecting edge (curr, m[0]): replace child m[0]'s contribution
                // from dfs(0, m[0]) with dfs(1, m[0]) + edge weight, keep all other children unchanged.
                take = Math.max(take, skip
                                - dfs(0, m[0], map, memo)
                                + dfs(1,m[0],map, memo)
                                + m[1]); 
            }
        }
        return memo[curr][mode] = Math.max(take, skip);
    }
}