class Solution {
    int m,n,res;
    // 25ms
    public boolean isThereAPathInitial(int[][] grid) {
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

    Boolean[][][] memo;
    int k;
    public boolean isThereAPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if ((n+m) % 2 == 0) return false;
        k = (n+m) / 2; // Target sum
        // Memo up to k, no need for after k since we know it'll be False
        memo = new Boolean[n][m][k+1];
        return isThereAPath(grid, 0, 0, 0);
    }

    public boolean isThereAPath(int[][] grid, int x, int y, int sum) {
        if (x >= n || y >= m) return false;
        sum += grid[x][y];
        // Sum shouldn't be more than k.
        // Also, n+m is max possible sum and x+y is what we've seen so far. Their difference
        // is the remaining cells, which must be at least k-sum (otherwise we won't get to k == sum)
        if (sum > k || n+m-x-y < k-sum) return false; // Optimization/Optional
        if (x == n-1 && y == m-1) return memo[x][y][sum] = sum == k;
        if (memo[x][y][sum] != null) return memo[x][y][sum];
        return memo[x][y][sum] = isThereAPath(grid, x+1, y, sum) || isThereAPath(grid, x, y+1, sum);
    }
}