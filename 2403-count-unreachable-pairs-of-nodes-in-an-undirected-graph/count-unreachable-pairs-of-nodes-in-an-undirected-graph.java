class UnionFind{
    int[] ranks;
    int[] parent;
    UnionFind(int n){
        this.ranks = new int[n];
        this.parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }
    void union(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar==yPar) return;
        else if(ranks[xPar]>ranks[yPar]){
            parent[yPar] = xPar;
        }else if(ranks[xPar]<ranks[yPar]){
            parent[xPar] = yPar;
        }else{
            parent[yPar] = xPar;
            ranks[xPar]++;
        }
    }
}
class Solution {
    public long countPairs(int n, int[][] edges) {

        UnionFind uf  = new UnionFind(n);
        for(int[] edge:edges) uf.union(edge[0],edge[1]);
        for(int i=0;i<n;i++) uf.find(i);
        long res = 0, singles = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int par:uf.parent){
            hashMap.put(par,hashMap.getOrDefault(par,0)+1);
        }
        long remaining = n;
        for(Map.Entry<Integer,Integer> e: hashMap.entrySet()){
            remaining-=e.getValue();
            res +=remaining*e.getValue();
        }
        return res;
    }
}