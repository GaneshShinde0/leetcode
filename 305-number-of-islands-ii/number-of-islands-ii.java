class UnionFind{
    int[] rank;
    int[] parent;
    int count;
    UnionFind(int n){
        rank = new int[n];
        parent = new int[n];
        this.count = 0;
        Arrays.fill(parent,-1); // Filling with -1 as our array starts with 0.
    }
    int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar==yPar) return;
        if(rank[xPar]>rank[yPar]){
            parent[yPar] = xPar;
        }else if(rank[xPar]<rank[yPar]){
            parent[xPar]=yPar;
        }else if(rank[xPar]==rank[yPar]){
            parent[yPar]= xPar;
            rank[xPar]++;
        }
        count--;
    }

    int numberOfIslands(){ 
        return count;
    }
    boolean isLand(int x){
        return parent[x]>=0;
    }

    void addLand(int x){
        if(parent[x]>=0) return; // Already land
        parent[x]=x;
        count++;
    }
}

class Solution {
    private static final int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind dsu = new UnionFind(m*n);
        List<Integer> answer = new ArrayList<>();
        for(int[] pos:positions){
            int encodePos = pos[0]*n+pos[1];
            dsu.addLand(encodePos);
            for(int[] dir:dirs){
                int newX = pos[0]+dir[0];
                int newY = pos[1]+dir[1];
                int neighbor = newX*n+newY;
                if(newX<0||newY<0||newX>=m||newY>=n||!dsu.isLand(neighbor)) continue;
                dsu.union(encodePos,neighbor);
            }
            answer.add(dsu.numberOfIslands());
        }
        return answer;
    }
}