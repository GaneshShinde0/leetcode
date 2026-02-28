class Solution {
    private static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private int res;
    private int walkables;
    public int uniquePathsIII(int[][] obstacleGrid) {
        this.res = 0;
        this.walkables = 0;
        int m = obstacleGrid.length-1, n=obstacleGrid[0].length-1;
        int x=0,y=0;
        this.walkables=0;
        for(int i=0;i<=m;i++){
            for(int j=0; j<=n;j++){
                if(obstacleGrid[i][j]==1){
                    x=i;
                    y=j;
                }
                if(obstacleGrid[i][j]==0){
                    this.walkables++;
                }
            }
        }
        obstacleGrid[x][y]=Integer.MAX_VALUE;
        for(int[] dir:dirs){
            int ni = x+dir[0];
            int nj = y+dir[1];
            if(ni>m ||nj>n||ni<0||nj<0||obstacleGrid[ni][nj]==-1||obstacleGrid[ni][nj]==Integer.MAX_VALUE) continue;
            dfs(obstacleGrid, ni, nj, m, n, 0);
        }
        return this.res;
    }
    private void dfs(int[][] grid, int i, int j,int m, int n, int walked){       
        if(walked==this.walkables && grid[i][j]==2){
            this.res++;
            return;
        }else if(grid[i][j]==2) {
            return;
        }else if(grid[i][j]==0){
            grid[i][j]=Integer.MAX_VALUE; 
            for(int[] dir:dirs){
                int ni = i+dir[0];
                int nj = j+dir[1];
                if(ni>m ||nj>n||ni<0||nj<0||grid[ni][nj]==-1||grid[ni][nj]==Integer.MAX_VALUE) continue;
                walked++;
                dfs(grid, ni, nj, m, n, walked);
                walked--;
            }
            grid[i][j] = 0;
        }
    }
}