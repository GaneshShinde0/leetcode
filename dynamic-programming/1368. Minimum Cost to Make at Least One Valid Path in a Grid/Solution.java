class Solution {
    public int minCost(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] res = new int[rows][cols];
        for(int[] row:res){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        res[0][0]=0;
        while(true){
            int[][] prevState = new int[rows][cols];
            for(int row = 0;row<rows;row++){
                prevState[row]=Arrays.copyOf(res[row],cols);
            }
            // Forward Pass: Check cells coming from left and top
            for(int row = 0; row<rows; row++){
                for(int col=0;col<cols; col++){
                    if(row>0){
                        res[row][col] = Math.min(
                            res[row][col],
                            res[row-1][col]+(grid[row-1][col]==3?0:1)
                        );
                    }
                    if(col>0){
                        res[row][col] = Math.min(
                            res[row][col],
                            res[row][col - 1] +
                            (grid[row][col - 1] == 1 ? 0 : 1)
                        );
                    }
                }
            }

            // Backward Pass: Check cells coming from right and bottom.
            for(int row = rows-1; row>=0; row--){
                for(int col = cols-1; col>=0; col--){
                    if(row<rows-1){
                        res[row][col]= Math.min(res[row][col], res[row+1][col]+(grid[row+1][col]==4?0:1));
                    }
                    if(col<cols-1){
                        res[row][col]=Math.min(res[row][col], res[row][col+1]+(grid[row][col+1]==2?0:1));
                    }
                }
            }
            if(Arrays.deepEquals(prevState, res)) break;
        }
        return res[rows-1][cols-1];
    }
}
