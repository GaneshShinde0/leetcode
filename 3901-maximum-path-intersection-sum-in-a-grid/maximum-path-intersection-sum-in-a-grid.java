class Solution {
    public int maxScore(int[][] grid) {
        int sum = Integer.MIN_VALUE, m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            int curr = grid[i][0];
            for(int j=1;j<n;j++){
                int len = curr+grid[i][j];
                sum = Math.max(sum, len);
                if(i>0 && i<m-1 && j>0 && j<n-1) sum = Math.max(sum, grid[i][j]);
                curr = Math.max(grid[i][j], grid[i][j]+curr);
            }
        }
        for(int j=0;j<n;j++){
            int curr = grid[0][j];
            for(int i=1;i<m;i++){
                int len = curr+grid[i][j];
                sum = Math.max(sum,len);
                if(i>0 && i<m-1 && j>0 && j<n-1) sum = Math.max(sum, grid[i][j]);
                curr = Math.max(grid[i][j], grid[i][j]+curr);
            }
        }
        return sum;
    }
}