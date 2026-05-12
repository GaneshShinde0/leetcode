class Solution {
    private final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int m,n;
    int currVis;
    public long sumRemoteness(int[][] grid) {
        
        long totalSum = 0, result = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=-1){
                    totalSum+=grid[i][j];
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=-1){
                    this.currVis = 0;
                    result += (totalSum-dfs(grid,i,j))*this.currVis;
                }
            }
        }
        return result;
    }

    private long dfs(int[][] grid, int i, int j){
        long sum=grid[i][j];
        this.currVis++;
        grid[i][j] = -1;
        for(int[] dir:dirs){
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if(newI<0||newJ<0||newI>=m||newJ>=n||grid[newI][newJ]==-1) continue;
            sum+=dfs(grid,newI,newJ);
        }
        return sum;
    }
}