class Solution {
    int m,n,res;
    public boolean isThereAPath(int[][] grid) {
       this.m = grid.length;
       this.n = grid[0].length;
       if((m+n)%2==0) return false;
    //    boolean[][][] memo = new boolean[m][n][m+n];// This will store by default false; we need to identify if it was calculated before so we will use Boolean 
        Boolean[][][] memo = new Boolean[m][n][m+n];

        return dfs(0,0,grid,grid[0][0],memo);
    }
    private boolean dfs(int i, int j,int[][] grid,int curr,Boolean[][][] memo){
        if(i==m-1 && j==n-1 && curr==(m+n)/2){
            memo[i][j][curr] = true;
            return true;
        }
        if(i==m||j==n) return false;
        if(memo[i][j][curr]!=null) return memo[i][j][curr];
        boolean temp = false;
        if(i<m-1 ){
            temp|=dfs(i+1,j,grid,curr+grid[i+1][j],memo);
        }
        if(j<n-1){
            temp|=dfs(i,j+1,grid,curr+grid[i][j+1],memo);
        }
        memo[i][j][curr] = temp;
        return temp;
    }
}