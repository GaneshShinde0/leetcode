class UnionSet{
    int[] rank;
    int[] parent;
    int[] size;

    UnionSet(int n){
        rank = new int[n];
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int x){
        if(x!=parent[x]) parent[x]=find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar==yPar) return;
        if(rank[xPar]<rank[yPar]){
            parent[xPar] = yPar;
            size[yPar]+=size[xPar];
        }else if(rank[yPar]<rank[xPar]){
            parent[yPar] = xPar;
            size[xPar]+=size[yPar];
        }else{
            parent[yPar] = xPar;      // FIX: Use yPar (root), not y
            rank[xPar]++;
            size[xPar] += size[yPar]; 
        }
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        UnionSet us = new UnionSet(n);
        for(int[] edge:edges){
            us.union(edge[0],edge[1]);
        }
        Map<Integer, Integer> edgeCount = new HashMap<>();
        for(int[] edge:edges){
            int root = us.find(edge[0]);
            edgeCount.put(root,edgeCount.getOrDefault(root,0)+1);
        }
        System.out.println(Arrays.toString(us.size));
        int res = 0;
        for(int i=0;i<n;i++){
            if(us.find(i)==i){
                int nodeCount = us.size[i];
                int expectedEdges = nodeCount*(nodeCount-1)/2;
                if(edgeCount.getOrDefault(i,0)==expectedEdges) res++;
            }
        }
        return res;
    }
}