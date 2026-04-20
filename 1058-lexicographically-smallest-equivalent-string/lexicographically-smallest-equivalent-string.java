class UnionFind{
    int[] rank;
    int[] parent;
    UnionFind(int n){
        this.rank = new int[n];
        this.parent = new int[n];
        for(int i=0;i<n;i++){
            rank[i]=i;
            parent[i]=i;
        }
    }

    int find(int x){
        if(parent[x]!=x) parent[x]= find(parent[x]);
        return parent[x];
    }

    void union(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(rank[xPar]<rank[yPar]){
            parent[yPar]=xPar;
        }else if(rank[yPar]<rank[xPar]){
            parent[xPar]=yPar;
        }
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);
        for(int i=0;i<s1.length();i++){
            int a = s1.charAt(i)-'a';
            int b = s2.charAt(i)-'a';
            uf.union(a,b);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            sb.append((char)(uf.find(baseStr.charAt(i)-'a')+'a'));
        }
        return sb.toString();
    }
}