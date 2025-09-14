class Solution {
    private static final int[][] directions = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false&&grid[i][j]=='1'){
                    res++;
                    dfs(grid, visited,i,j,m,n);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j,int m, int n){
        if(visited[i][j]) return;
        visited[i][j]=true;
        if(grid[i][j]=='1'){
            for(int[] dir:directions){
                int newI = i+dir[0];
                int newJ = j+dir[1];
                if(newI>=m||newI<0||newJ>=n||newJ<0) continue;
                dfs(grid,visited,newI,newJ,m,n);
            }
        }
    }
}