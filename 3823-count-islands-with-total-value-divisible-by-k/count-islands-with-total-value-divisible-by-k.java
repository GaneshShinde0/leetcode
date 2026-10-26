class Solution {
    int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
    int m,n;
    public int countIslands(int[][] grid, int k) {
        this.m = grid.length;
        this.n = grid[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    long sum=dfs(grid,i,j);
                    if(sum%k==0) res++;
                    // System.out.println(sum);
                }
            }
        }
        return res;
    }
    private long dfs(int[][] grid, int i, int j){
        long sum=grid[i][j];
        grid[i][j]=0;
        for(int[] dir:dirs){
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if(newI<0||newJ<0||newI>=m||newJ>=n||grid[newI][newJ]==0) continue;
            sum+=dfs(grid, newI, newJ);
        }
        return sum;
    }
}