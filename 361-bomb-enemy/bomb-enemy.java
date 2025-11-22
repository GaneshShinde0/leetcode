class Solution {
    private int[] dir = {1,-1};
    int m;
    int n;
    public int maxKilledEnemiesInitial(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(grid[i][j]=='0')res = Math.max(res,canKill(i,j,grid));
            }
        }
        return res;
    }
    private int canKill(int i, int j, char[][] grid){
        int currRes = 0;
        for(int d:dir){
            for(int ix = i;ix<m&&ix>=0;ix+=d){
                if(grid[ix][j]=='E'){
                    currRes++;
                }else if(grid[ix][j]=='W'){
                    break;
                }
            }
        }
        for(int d:dir){
            for(int iy = j;iy<n&&iy>=0;iy+=d){
                if(grid[i][iy]=='E'){
                    currRes++;
                }else if(grid[i][iy]=='W'){
                    break;
                }
            }
        }
        return currRes;
    }
    public int maxKilledEnemies(char[][] grid) {
        int[][] dp     = new int[grid.length][grid[0].length];
        int[] colCount = new int[grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            int rowCount = 0;
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 'E') { rowCount++; colCount[c]++; }
                else if (grid[r][c] == 'W') { rowCount = colCount[c] = 0; }
                else dp[r][c] = rowCount + colCount[c];
            }
        }

        Arrays.fill(colCount, 0);

        int max = 0;
        for (int r = grid.length-1; r > -1; r--) {
            int rowCount = 0;
            for (int c = grid[0].length-1; c > -1; c--) {
                if (grid[r][c] == 'E') { rowCount++; colCount[c]++; }
                else if (grid[r][c] == 'W') { rowCount = colCount[c] = 0; }
                else { dp[r][c] += rowCount + colCount[c]; max = Math.max(max, dp[r][c]); }
            }
        }

        return max;
    }
}