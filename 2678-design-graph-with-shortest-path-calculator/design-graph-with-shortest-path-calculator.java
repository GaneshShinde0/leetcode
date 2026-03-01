class Graph {
    int[][] grid;
    int n;
    public Graph(int n, int[][] edges) {
        this.grid = new int[n][n];
        for(int[] g:grid) Arrays.fill(g,10000000);
        this.n = n;
        for(int[] edge:edges){
            int i = edge[0];
            int j = edge[1];
            int cost = edge[2];
            grid[i][j] = cost;
        }
        for(int i=0;i<n;i++) grid[i][i]=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j] = Math.min(grid[i][j],grid[i][k]+grid[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int cost = edge[2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = Math.min(grid[i][j], grid[i][u]+cost+grid[v][j]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return grid[node1][node2]==10000000?-1:grid[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */