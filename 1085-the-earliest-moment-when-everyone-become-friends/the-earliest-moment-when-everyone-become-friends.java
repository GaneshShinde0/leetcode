/*
[20190101,0,1],
[20190104,3,4],
[20190107,2,3],
[20190211,1,5],
[20190224,2,4],
[20190301,0,3],
[20190312,1,2],
[20190322,4,5]

0 -> 1 - 5 - 3 -> 4 - 2

[0,2,0],
[1,4,3]
[2,1,0],
[3,1,2],
[4,5,3],
[6,1,5],
[7,4,2],
[9,1,3],
[11,5,4]

2 0 1
4 3 5


*/
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

    public int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void unionSet(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar==yPar) return;
        else if(rank[xPar]<rank[yPar]){
            parent[xPar] = yPar; // Make Parent which has higher rank
        }else if(rank[xPar]>rank[yPar]){
            parent[yPar] = xPar; 
        }else{
            parent[yPar] = xPar;
            rank[x]++;
        }
    }
}
class Solution {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs,(a,b)->Integer.compare(a[0],b[0]));
        UnionFind uf = new UnionFind(n);
        int res = -1;
        for(int[] log:logs){
            if(uf.find(log[1])!=uf.find(log[2])){
                res = log[0];
                uf.unionSet(log[1],log[2]);
            }
        }
        for(int i=0;i<n-1;i++){
            if(uf.find(i)!=uf.find(i+1)) return -1;
        }
        return res;
    }
}