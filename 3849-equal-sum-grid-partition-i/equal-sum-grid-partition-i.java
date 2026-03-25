class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long totalSum =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                totalSum+=grid[i][j];
            }
        }
        return (checkRowWise(grid,totalSum,m,n)) || checkColumnWise(grid, totalSum, m, n);
    }

    private boolean checkRowWise(int[][] grid, long totalSum, int m, int n){
        long suffixSum = 0;
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
                suffixSum+=grid[i][j];
            }
            if(totalSum == 2*suffixSum) return true;
        }
        return false;
    }
    private boolean checkColumnWise(int[][] grid, long totalSum, int m, int n){
        long suffixSum = 0;
        for(int j=0;j<n;j++){
            for(int i=m-1;i>=0;i--){
                suffixSum+=grid[i][j];
            }
            if(totalSum == 2*suffixSum) return true;
        }
        return false;
    }

}