class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // j == n-1, i==m-1 considers cases when we are dealing with last row and last column
                if(board[i][j]=='X' && (j==n-1 ||board[i][j+1]=='.') && (i==m-1 || board[i+1][j]=='.')) count++;
            }
        }
        return count;
    }

     public void battleships(char[][] board,int[][] dir,boolean[][] visited,int work_row,int work_col,int total_rows,int total_cols)
    {
        for(int i=0;i<dir.length;i++)
        {
            int cal_row=work_row + dir[i][0];
            int cal_col=work_col + dir[i][1];
            if(cal_row>=0 && cal_col>=0 && cal_row<total_rows && cal_col < total_cols && visited[cal_row][cal_col]!=true && board[cal_row][cal_col]!='.')
            {
                visited[cal_row][cal_col]=true;
                battleships(board,dir,visited,cal_row,cal_col,total_rows,total_cols);
            }
        }
    }
    public int countBattleshipsDFS(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int count=0;
        int[][] dir ={{0,1},{1,0}};
        boolean[][] visited = new boolean [n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='X' && visited[i][j]==false)
                {
                    count++;
                    visited[i][j]=true;
                    battleships(board,dir,visited,i,j,n,m);
                }
            }
        }
        return count;
    }
}