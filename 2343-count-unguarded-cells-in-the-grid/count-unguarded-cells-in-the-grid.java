class Solution {
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    char[][] grid ;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        this.grid= new char[m][n];
        for(int[] guard:guards){
            grid[guard[0]][guard[1]] = 'G';
        }
        for(int[] wall:walls){
            grid[wall[0]][wall[1]] = 'W';
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='G') {
                    for(int[] dir:dirs){
                        dfs(m,n,i+dir[0],j+dir[1],dir[0],dir[1],grid);
                    }
                }
            }
        }

        int res = 0;
        for(int i=0;i<m;i++){
            // System.out.println(Arrays.toString(grid[i]));
            for(int j=0;j<n;j++){
                if(grid[i][j]=='\u0000') res++;
            }
        }
        return res;
        
    }
    private void dfs(int m, int n, int i, int j, int rowDir, int colDir, char[][] grid){
        if(i>=m||i<0|j>=n||j<0||grid[i][j]=='G'||grid[i][j]=='W') return;
        grid[i][j]='N';
        dfs(m,n,i+rowDir,j+colDir,rowDir,colDir,grid);
    }
}