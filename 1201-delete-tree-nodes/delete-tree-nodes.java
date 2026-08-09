class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        Map<Integer,Set<Integer>> tree = new HashMap<>();
        for(int i=0;i<nodes;i++){
            tree.computeIfAbsent(parent[i], x-> new HashSet<>()).add(i);
        }
        int[] sumAndCount = dfs(tree, value, 0);
        return sumAndCount[1];
    }
    private int[] dfs(Map<Integer,Set<Integer>> tree, int[] value, int curr){
        int sum = value[curr], count = 1;
        if(!tree.containsKey(curr)) return new int[]{sum, sum==0?0:count};
        for(int neighbor: tree.get(curr)){
            int[] next = dfs(tree,value,neighbor);
            sum += next[0];
            count += next[1];
        }
        return new int[]{sum, sum==0?0:count};
    }
}