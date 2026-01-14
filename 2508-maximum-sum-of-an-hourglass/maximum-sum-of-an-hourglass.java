class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j]+=grid[i][j-1];
                // if(j>2) grid[i][j]-=grid[i][j-3];
            }
            System.out.println(Arrays.toString(grid[i]));
        }
        int res = 0;
        for(int i=1;i<m-1;i++){
            for(int j=2;j<n;j++){
                // System.out.println( grid[i-1][j]-grid[i-1][j-3]+grid[i+1][j]-grid[i+1][j-3]+grid[i][j-1]-grid[i][j-2]);
                int curr = Math.max(res,grid[i-1][j]+grid[i+1][j]+grid[i][j-1]-grid[i][j-2]);
                if(j>2) curr = curr -grid[i-1][j-3]-grid[i+1][j-3];
                res = Math.max(res,curr);
            }
        }
        return res;
    }
}