class Solution {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(isConnected, vis, n, i);
                cnt++;
            }
        }
        return cnt;
    }
    // This DFS will visit all the rows and columns for particullar index.
    public void dfs(int[][] isConnected, int[] vis, int n, int u){
        vis[u]=1;
        for(int v=0;v<n;v++){
            if(vis[v]==0&&isConnected[u][v]==1){
                dfs(isConnected,vis,n,v);
            }
        }
    }
}