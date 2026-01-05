class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int size){
        parent = new int[size];
        rank = new int[size];
        for(int i=0;i<size;i++) parent[i] = i; // Initially Each Node is its own parent in UnionFind/Disjoint Sets
    }

    public int find(int x){
        // Check Following Later
        // return parent[x];
        if(parent[x]!=x) parent[x] =find(parent[x]); // Check Parents until we find node with same parent.
        return parent[x];
    }

    public void union_set(int x, int y){
        int xset = find(x), yset = find(y);
        if(xset==yset) return;
        else if(rank[xset]<rank[yset]){ // Y's parent has higher rank. Make yset as parent of x;
            parent[xset] = yset; 
        }else if(rank[xset]>rank[yset]){ // X's parent has higher rank. Make xset as parent of y; 
            parent[yset] = xset;
        }else{
            parent[yset]=xset; // By Defaut make xset as parent of yset.
            rank[xset]++; /// As xset became parent we will increase its rank;
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        int numberOfComponents = n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1 && uf.find(i)!=uf.find(j)){ // If points are connnected and dont have common parent;
                    numberOfComponents--;
                    uf.union_set(i,j);
                }
            }
        }
        return numberOfComponents;
    }
}