class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // j == n-1, i==m-1 considers cases when edges have 0 length
                if(board[i][j]=='X' && (j==n-1 ||board[i][j+1]=='.') && (i==m-1 || board[i+1][j]=='.')) count++;
            }
        }
        return count;
    }
}