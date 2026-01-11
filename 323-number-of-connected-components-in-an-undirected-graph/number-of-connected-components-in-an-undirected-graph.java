// Build a Graph,
// Perform a DFS.
// Space Complexity 
    // O(E) for Edges
    // O(N) for visited,
// Time Complextiy
    // O(N) - Number of Nodes
    // O(E) - Number of edges
class Solution {
    public int countComponentsDFS(int n, int[][] edges) {
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

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge:edges){
            uf.union(edge[0],edge[1]);
        }
        System.out.println(Arrays.toString(uf.parent));
        Set<Integer> set = new HashSet<>();
        for(int i:uf.parent){
            set.add(uf.find(i));
        }
        return set.size();
    }
}

class UnionFind{
    int[] parent;
    int[] rank;
    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)parent[i]=i;
    }
    int find(int x){
        if(x!=parent[x]) parent[x]=find(parent[x]);
        return parent[x];
    }
    void union(int x, int y){
        int xPar=find(x), yPar = find(y);
        if(xPar==yPar) return;
        else if(rank[xPar]<rank[yPar]){
            parent[xPar] = yPar;
            // rank[xPar]=rank[yPar];
        }else if(rank[yPar]<rank[xPar]){
            parent[yPar]=xPar;
            // rank[yPar] = rank[xPar];
        }else{
            parent[yPar]=xPar;
            rank[xPar]++;
        }
    }


}