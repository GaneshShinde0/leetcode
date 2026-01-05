class UnionFind{
    int[] parent;
    int[] rank;
    
    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
    }
    protected int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }
    protected boolean union(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar==yPar) return false; // Already present in new graph no need to add
        else if(rank[xPar]<rank[yPar]){
            parent[xPar]=yPar;
        }else if( rank[yPar]<rank[xPar]){
            parent[yPar] = parent[xPar];
        }else{
            parent[yPar] = xPar;
            rank[xPar]++;
        }
        return true;
    }
}
class Solution {
    public int minCostConnectPointsInital346ms(int[][] points) {
        
        int n = points.length;
        ArrayList<int[]> allEdges = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int weight = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                allEdges.add(new int[]{weight,i,j});
            }
        }

        Collections.sort(allEdges, (a,b)->Integer.compare(a[0],b[0]));
        UnionFind uf = new UnionFind(n);
        int mostCost = 0;
        int edgesUsed=0;
        for(int i=0;i<allEdges.size() && edgesUsed<n-1; i++){
            int x = allEdges.get(i)[1];
            int y = allEdges.get(i)[2];
            if(uf.union(x,y)){
                mostCost+=allEdges.get(i)[0];
                edgesUsed++;
            }
        }
        return mostCost;
    }
    public int minCostConnectPointsPrimsOptimized(int[][] points) {
        int n = points.length;
        int mstCost = 0;
        int edgesUsed = 0;
        
        // Track nodes which are visited.
        boolean[] inMST = new boolean[n];
        
        int[] minDist = new int[n];
        minDist[0] = 0;
        
        for (int i = 1; i < n; ++i) {
            minDist[i] = Integer.MAX_VALUE;
        }
        
        while (edgesUsed < n) {
            int currMinEdge = Integer.MAX_VALUE;
            int currNode = -1;
            
            // Pick least weight node which is not in MST.
            for (int node = 0; node < n; ++node) {
                if (!inMST[node] && currMinEdge > minDist[node]) {
                    currMinEdge = minDist[node];
                    currNode = node;
                }
            }
            
            mstCost += currMinEdge;
            edgesUsed++;
            inMST[currNode] = true;
            
            // Update adjacent nodes of current node.
            for (int nextNode = 0; nextNode < n; ++nextNode) {
                int weight = Math.abs(points[currNode][0] - points[nextNode][0]) + 
                             Math.abs(points[currNode][1] - points[nextNode][1]);
                
                if (!inMST[nextNode] && minDist[nextNode] > weight) {
                    minDist[nextNode] = weight;
                }
            }
        }
        
        return mstCost;
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length, edgesUsed = 0, mostPoints = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        boolean[] inMST = new boolean[n];

        pq.add(new int[]{0,0});

        while(edgesUsed<n){
            int[] curr = pq.poll();
            int weight = curr[0];
            int node = curr[1];
            if(inMST[node]) continue;
            inMST[node] = true;
            edgesUsed++;
            mostPoints+=weight;
            for(int i=0;i<n;i++){
                if(!inMST[i]){
                    int newWt = Math.abs(points[node][0]-points[i][0])+Math.abs(points[node][1]-points[i][1]);
                    pq.add(new int[]{newWt,i});
                }
            }
        }
        return mostPoints;
    }
}