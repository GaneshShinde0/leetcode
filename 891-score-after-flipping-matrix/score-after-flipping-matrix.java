class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==0) toggleRow(grid,i);
        }
        for(int j=0;j<grid[0].length;j++){
            int ones = countOnes(grid,j);
            res += Math.max(ones,m-ones)*Math.pow(2,n-j-1);
        }
        return res;
    }
    private int countOnes(int[][] grid, int col){
        int count = 0;
        for(int i=0;i<grid.length;i++){
            if(grid[i][col]==1) count++;
        }
        return count;
    }
    private void toggleRow(int[][] grid, int idx){
        for(int j=0;j<grid[idx].length;j++){
            if(grid[idx][j]==0){
                grid[idx][j]=1;
            }else{
                grid[idx][j]=0;
            }
        }
    }
}