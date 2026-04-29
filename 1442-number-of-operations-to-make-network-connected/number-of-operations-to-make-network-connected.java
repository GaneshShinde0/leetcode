
class Solution {
    Map<Integer, Set<Integer>> graph;
    public int makeConnected(int n, int[][] connections) {
        int cables = connections.length;
        if(cables<n-1) return -1;
        graph = new HashMap<>();
        for(int[] edge:connections){
            graph.computeIfAbsent(edge[0],x->new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1],x->new HashSet<>()).add(edge[0]);
        }
        int groups =  0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i, vis);
                groups++;
            }
        }
        return groups-1;
    }
    private void dfs(int curr, boolean[] vis){
        if(vis[curr] || !graph.containsKey(curr)) return;
        vis[curr] = true;
        for(int i:graph.get(curr)){
            dfs(i,vis);
        }
    }
}