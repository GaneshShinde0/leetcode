class Solution {
    public int removeOnes(int[][] grid) {
        int m = grid.length, n = grid[0].length, minFlips = Integer.MAX_VALUE;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;
                for(int k=0;k<m;k++){
                    row[k] = grid[k][j];
                    grid[k][j]=0;
                }
                for(int k=0;k<n;k++){
                    col[k] = grid[i][k];
                    grid[i][k]=0;
                }
                minFlips = Math.min(minFlips, 1+removeOnes(grid));
                for(int k=0;k<m;k++){
                    grid[k][j] = row[k];
                }
                for(int k=0;k<n;k++){
                    grid[i][k] = col[k];
                }
                grid[i][j] = 1;
            }
        }
        return minFlips==Integer.MAX_VALUE?0:minFlips;
    }
}