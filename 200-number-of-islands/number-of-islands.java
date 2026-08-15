class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m,n;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int numOfIslands = 0;
        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    private void dfs(char[][] grid, int i, int j){
        grid[i][j]='0';
        for(int[] dir:dirs){
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if(newI>=m||newJ>=n||newI<0||newJ<0||grid[newI][newJ]=='0') continue;
            dfs(grid,newI,newJ);
        }
    }
}