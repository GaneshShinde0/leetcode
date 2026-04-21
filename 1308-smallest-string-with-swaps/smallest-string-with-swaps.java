class UnionFind{
    int[] rank;
    int[] parent;
    UnionFind(int n){
        rank = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }
    int find(int x){
        if(x!=parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar==yPar) return;
        else if(rank[xPar]>rank[yPar]){
            parent[yPar] = xPar;
        }else if(rank[xPar]<rank[yPar]){
            parent[xPar] = yPar;
        }else{
            rank[xPar]++;
            parent[yPar] = xPar;
        }
    }
}
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        pairs.stream().forEach(x->uf.union(x.get(0),x.get(1)));
        Map<Integer, int[]> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            int iPar = uf.find(i);
            int[] curr = hm.computeIfAbsent(iPar,x->new int[26]);
            curr[s.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int iPar = uf.find(i);
            int[] curr = hm.get(iPar);
            for(int j=0;j<26;j++){
                if(curr[j]>0){
                    sb.append((char)('a'+j));
                    curr[j]--;
                    break;
                }
            }
        }
        return sb.toString();
    }
}