class UnionFind{
    int[] parent;
    int[] rank;

    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public int find(int x){
        if(x!=parent[x]) x=find(parent[x]);
        return x;
    }
    public void unionSet(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar==yPar) return;
        if(rank[xPar]<rank[yPar]){
            parent[xPar]=yPar;
        }else if(rank[yPar]<rank[xPar]){
            parent[yPar]=yPar;
        }else{
            parent[yPar]=xPar;
        }
    }
}
class Solution {

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        // A Tree Is Valid if every node has one parent.
        for(int[] edge:edges){
            if(uf.find(edge[0])==uf.find(edge[1])) return false;
            uf.unionSet(edge[0],edge[1]);
        }
        for(int i=0;i<n-1;i++){
            if(uf.find(i)!=uf.find(i+1)) return false;
        }
        return true;
    }
}