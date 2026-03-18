class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        // Question asks -> It asks for submatrices that include the top-left element of the grid (i.e., grid[0][0]).

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0) grid[i][j]+=grid[i-1][j];
                if(j>0) grid[i][j]+=grid[i][j-1];
                if(i>0&&j>0) grid[i][j]-=grid[i-1][j-1];
                if(grid[i][j]<=k) result++;
            }
        }
        return result;
    }
}