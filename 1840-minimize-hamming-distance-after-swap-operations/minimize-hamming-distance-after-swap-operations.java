/*
Approach:
Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]

Union All the swaps using union find algorithm-> Inputs are scattered if start = 0 end = 9999 we will have to crease arrray with size 9999.
Have HashMap to count frequencies?


*/

class UnionFind{
    int[] rank;
    int[] parent;
    UnionFind(int n){
        rank = new int[n];
        parent = new int[n];
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
        if(rank[xPar]>rank[yPar]){
            parent[yPar]=xPar;
        }else if(rank[xPar]<rank[yPar]){
            parent[xPar]=yPar;
        }else{
            rank[xPar]++;
            parent[yPar]=xPar;
        }
    }
}
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        for(int[] allowed:allowedSwaps){
            uf.union(allowed[0],allowed[1]);
        }

        for(int i=0;i<n;i++){
            int iPar = uf.find(i);
            hm.putIfAbsent(iPar, new HashMap<>());
            Map<Integer,Integer> counts = hm.get(iPar);
            counts.put(source[i], counts.getOrDefault(source[i],0)+1);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            int iPar = uf.find(i);
            Map<Integer, Integer> counts = hm.get(iPar);
            if(counts.getOrDefault(target[i],0)>0){
                counts.put(target[i], counts.get(target[i])-1);
            }else{
                ans++;
            }
        }
        return ans;
    }
}