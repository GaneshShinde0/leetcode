class Solution {
    public int largestMagicSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        
        // Iterate through all possible kxk subgrids
        for(int k=Math.min(rows,cols);k>0;k--){
            for (int i = 0; i <= rows - k; i++) {
                for (int j = 0; j <= cols - k; j++) {
                    if (isMagicSquare(grid, i, j, k)) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }
    private boolean isMagicSquare(int[][] grid, int row, int col, int k) {
        // Check if all numbers are distinct and between 1 and 9
        
        // Check the sums of rows, columns, and diagonals
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=grid[row+0][col+i];
        } 
        // Row, Col
        for(int i=0;i<k;i++){
            int currSum1 =0, currSum2=0;
            for(int j=0;j<k;j++){
                currSum1 +=grid[row+i][col+j];
                currSum2 +=grid[row+j][col+i];
            }
            if(currSum1!=sum||currSum2!=sum) return false;
        } 
        int diag1= 0,diag2=0;
        for(int i=0;i<k;i++){
            diag1+=grid[row+i][col+i];
        }
        for(int i=k-1;i>=0;i--){
            diag2+=grid[row+i][col+k-i-1];
        }
        if(diag1!=sum||diag2!=sum) return false;
        return true;
    }
}