class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int row1 = 0; row1<m; row1++){
            for(int row2 = row1+1; row2<m; row2++){
                int count = 0;
                for(int col = 0;col <n; col++){
                    if(grid[row1][col]==1 && grid[row2][col]==1){
                        count++;
                    }
                }
                res += count*(count-1)/2;
            }
        }
        return res;
    }
}