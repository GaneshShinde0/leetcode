class UnionFind{
    int n;
    int[] rank;
    int[] parent;
    UnionFind(int n){
        this.rank = new int[n];
        this.parent = new int[n];
        for(int i=0;i<n;i++){
            this.parent[i] = i;
        }
    }
    public void union(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar==yPar) return;
        else if(rank[xPar]>rank[yPar]){
            parent[yPar] = xPar;
        }else if(rank[xPar]<rank[yPar]){
            parent[xPar] = yPar;
        }else{
            parent[yPar] = xPar;
            rank[xPar]++;
        }
    }
    public int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }
}
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int left = 0, right = 1;
        UnionFind uf = new UnionFind(n);
        while(right<n){
            while(right<n && nums[right]-nums[left]<=maxDiff){
                uf.union(left,right);
                right++;
            }
            left++;
        }
        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];
            int u = query[0], v = query[1];
            if(uf.find(u)==uf.find(v)) res[i] = true;
        }
        return res;
    }
}