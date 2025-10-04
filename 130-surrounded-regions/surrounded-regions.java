class Solution {
    // Following implementation fails for [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","O","X"]]
    // Question is basically asking to keep all O's that can be reached from boundary.
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    // public void solve(char[][] board) {
    //     int m = board.length;
    //     int n = board[0].length;

    //     for(int i=1;i<m-1;i++){
    //         for(int j=1;j<n-1;j++){
    //             for(int[] dir:dirs){
    //                 int nx = i+dir[0];
    //                 int ny = j+dir[1];
    //                 if(board[nx][ny]=='X' && !((board[i][0]=='O' && board[i][n-1]=='O')
    //                     || (board[0][j]=='O' && board[m-1][j]=='O'))){
    //                     board[i][j]='X';
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    // }

    public void solve(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]!='X')
            DFS(i,0,grid);
            if(grid[i][n-1]!='X')
            DFS(i,n-1,grid);
        }
        for(int i=0;i<n-1;i++){
            if(grid[0][i]!='X')
            DFS(0,i,grid);
            if(grid[m-1][i]!='X')
            DFS(m-1,i,grid);
        }
        swap(grid,'O','X');
        swap(grid,'p','O');  
    }

    void swap(char[][] grid,char p, char q){
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                    if(grid[i][j]==p) grid[i][j]=q;
    }

    void DFS(int i,int j, char[][] grid){
        if(i<0|| j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='O') return ;
        grid[i][j]='p';
        DFS(i+1,j,grid);
        DFS(i,j+1,grid);
        DFS(i-1,j,grid);
        DFS(i,j-1,grid);
    }
}
// [["X","O","X","X"]
// ,["O","X","O","X"]
// ,["X","O","X","O"]
// ,["O","X","O","X"]]