class SolutionInitial{
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

class Solution {
    int res = 0, empty = 1; // Start empty=1 to include starting square
    
    public int uniquePathsIII(int[][] grid) {
        int sx = 0, sy = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) empty++; // Count 0s
                else if (grid[i][j] == 1) {
                    sx = i; sy = j; // Found Start
                }
            }
        }
        dfs(grid, sx, sy);
        return res;
    }

    public void dfs(int[][] grid, int x, int y) {
        // 1. Boundary / Obstacle Check
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) return;
        
        // 2. Target Reached Check
        if (grid[x][y] == 2) {
            if (empty == 0) res++; // Check if we visited all nodes
            return;
        }

        // 3. Process Node
        grid[x][y] = -2; // Mark visited
        empty--; // Decrement count
        
        // 4. Recurse neighbors
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        
        // 5. Backtrack
        grid[x][y] = 0;
        empty++;
    }
}