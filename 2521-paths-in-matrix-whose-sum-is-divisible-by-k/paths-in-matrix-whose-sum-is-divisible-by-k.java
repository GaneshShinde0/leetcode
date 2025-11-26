class Solution {
    int[][] dirs = {{1,0},{0,1}};
    int paths = 0;
    private static final int MOD = 1000000007;
    public int numberOfPathsInitialDFS(int[][] grid, int k) {
        dfs(grid,new int[]{0,0},0,k);
        return this.paths;
    }
    private void dfs(int[][] grid, int[] pos,int sum, int k){
        int x = pos[0];
        int y = pos[1];
        sum+=grid[x][y];
        if(x==grid.length-1&&y==grid[0].length-1 && sum%k==0) this.paths++;
        for(int[] dir:dirs){
            int nx=x+dir[0];
            int ny=y+dir[1];
            if(nx<0||ny<0||nx>=grid.length||ny>=grid[0].length) continue;
            dfs(grid,new int[]{nx,ny},sum,k);
        }
    }
    
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        long[][][] dp = new long[m+1][n+1][k];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1){
                    dp[i][j][grid[0][0]%k]=1;
                    continue;
                }
                int value = grid[i-1][j-1]%k;
                for(int r=0;r<k;r++){
                    int prevMod = (r-value+k)%k;
                    dp[i][j][r]=(dp[i-1][j][prevMod]+dp[i][j-1][prevMod])%MOD;
                }
            }
        }
        return (int) dp[m][n][0];
    }
}