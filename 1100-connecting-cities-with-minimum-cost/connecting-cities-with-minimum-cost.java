class UnionFind{
    int[] rank;
    int[] parent;
    UnionFind(int n){
        this.rank = new int[n];
        this.parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar==yPar) return;
        else if(rank[xPar]>rank[yPar]){
            parent[yPar]=xPar;
        }else if(rank[xPar]<rank[yPar]){
            parent[xPar] = yPar;
        }else if(rank[xPar]==rank[yPar]){
            rank[xPar]++;
            parent[yPar]=xPar;
        }
    }
}
class Solution {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections,(a,b)->Integer.compare(a[2],b[2]));
        int res = 0,visited = 0;
        UnionFind uf = new UnionFind(n+1);
        for(int[] edge:connections){
            int u = edge[0], v = edge[1], cost = edge[2];
            if(uf.find(u)==uf.find(v)) continue;
            uf.union(u,v);
            res += cost;
            visited++;
        }
        return visited==n-1?res:-1;
    }
}