class Solution {
    private static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea =0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int temp = dfs(grid, i,j,1);
                    maxArea = Math.max(temp,maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j,int area){
        grid[i][j]=0;
        area = 1;
        for(int[] dir:directions){
            int newRow= dir[0]+i;
            int newCol = dir[1]+j;
            if(newRow>=0 && newCol>=0 && newRow<grid.length &&newCol<grid[0].length && grid[newRow][newCol]==1){
                area = area+dfs(grid,newRow,newCol,area);
                // System.out.println("I: "+i+", J: "+j+", Area: "+area);
            }
        }
        // System.out.println("Area: "+area);
        return area;
    }
}
