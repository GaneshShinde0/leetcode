class UnionFind{
    int[] parent;
    int[] rank;
    
    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
    }
    protected int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }
    protected boolean union(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar==yPar) return false; // Already present in new graph no need to add
        else if(rank[xPar]<rank[yPar]){
            parent[xPar]=yPar;
        }else if( rank[yPar]<rank[xPar]){
            parent[yPar] = parent[xPar];
        }else{
            parent[yPar] = xPar;
            rank[xPar]++;
        }
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        ArrayList<int[]> allEdges = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int weight = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                allEdges.add(new int[]{weight,i,j});
            }
        }

        Collections.sort(allEdges, (a,b)->Integer.compare(a[0],b[0]));
        UnionFind uf = new UnionFind(n);
        int mostCost = 0;
        int edgesUsed=0;
        for(int i=0;i<allEdges.size() && edgesUsed<n-1; i++){
            int x = allEdges.get(i)[1];
            int y = allEdges.get(i)[2];
            if(uf.union(x,y)){
                mostCost+=allEdges.get(i)[0];
                edgesUsed++;
            }
        }
        return mostCost;
    }
}