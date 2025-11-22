class Solution {
    private int[] dir = {1,-1};
    int m;
    int n;
    public int maxKilledEnemies(char[][] grid) {
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
}