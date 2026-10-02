class DistanceLimitedPathsExist {    
    int N = 10010, par[] = new int[N], rank[] = new int[N], weight[] = new int[N];
    final int imax = Integer.MAX_VALUE;
    public DistanceLimitedPathsExist(int n, int[][] eL) {
        Arrays.fill(weight, 0);
        Arrays.fill(rank, 1);
        for(int i = 0; i < n; i++) par[i] = i;
        Arrays.sort(eL, (e1, e2) -> e1[2] - e2[2]);
        for(int[] e : eL) union(e[0], e[1], e[2]);
    }    
    public boolean query(int p, int q, int limit) {
        return find(p, limit) == find(q, limit);
    }    
    int find(int i, int limit) {
        if(par[i] == i || weight[i] >= limit) return i;
        return find(par[i], limit);
    }    
    void union(int i, int j, int limit) {
        int ri = find(i, imax), rj = find(j, imax);
        // merge by size    150 ms
        if(ri != rj) {
            if(rank[ri] <= rank[rj]) {
                par[ri] = rj;
                rank[rj] += rank[ri];
                weight[ri] = limit;
            } else {
                par[rj] = ri;
                rank[ri] += rj;
                weight[rj] = limit;
            }
        }
    }
}