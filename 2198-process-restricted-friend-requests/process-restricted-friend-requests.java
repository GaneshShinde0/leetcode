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
        int xPar = find(x), yPar=find(y);
        if(xPar==yPar) return;
        else if(rank[xPar]>rank[yPar]){
            parent[yPar] = xPar;
        }else if(rank[yPar]>rank[xPar]){
            parent[xPar] = yPar;
        }else{
            rank[xPar]++;
            parent[yPar]= xPar;
        }
    }
}
class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        boolean[] result = new boolean[requests.length];
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<result.length;i++){
            int a = uf.find(requests[i][0]), b = uf.find(requests[i][1]);
            boolean canConnect =true;
            for(int[] r:restrictions){
                int x = uf.find(r[0]);
                int y = uf.find(r[1]);
                if((x==a&&y==b)||(x==b&&y==a)){
                    canConnect = false;
                    break;
                }
            }
            if(canConnect){
                uf.union(a,b);
            }
            result[i]=canConnect;   
        }
        return result;
    }
}

/*
public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind ruf = new UnionFind(n);
        Arrays.stream(restrictions).forEach(x->ruf.union(x[0],x[1]));
        Map<Integer, HashSet<Integer>> restricted = new HashMap<>();
        for(int[] r:restrictions){
            restricted.computeIfAbsent(r[0],k->new HashSet<Integer>()).add(r[1]);
            restricted.computeIfAbsent(r[1],k->new HashSet<Integer>()).add(r[0]);
        }
        boolean[] result = new boolean[requests.length];
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<result.length;i++){
            int a = uf.find(requests[i][0]), b = uf.find(requests[i][1]);
            
            if(!restricted.get(a).contains(b)){
                result[i]=true;
                uf.union(a,b);
            }
        }
        return result;
    }
*/