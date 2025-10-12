// Build a Graph,
// Perform a DFS.

class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        for(int[] edge:edges){
            hm.computeIfAbsent(edge[0],k->new ArrayList<Integer>()).add(edge[1]);
            hm.computeIfAbsent(edge[1],k->new ArrayList<Integer>()).add(edge[0]);
        }

        int numOfComponents = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!hm.containsKey(i)){
                numOfComponents++;
                continue;
            }
            if(!vis[i]){
                dfs(hm,vis,i);
                numOfComponents++;
            }
        }
        return numOfComponents;
    }

    private void dfs(HashMap<Integer,List<Integer>> hm, boolean[] vis,int i){
        vis[i]=true;
        for(int j:hm.get(i)){
            if(!vis[j]) dfs(hm,vis,j);
        }
    }
}