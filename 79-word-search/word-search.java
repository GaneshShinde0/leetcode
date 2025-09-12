class Solution {
    private static final int[][] directions = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if (dfs(board,word,i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col,int i){
        if(i==word.length()) return true;
        if((col<0 || col>=board[0].length) || (row<0 || row>=board.length)){
            return false;
        }
        boolean check = false;
        char temp = board[row][col];
        if(board[row][col]==word.charAt(i)){
            board[row][col]='/';
            for(int[] dir:directions){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                check |= dfs(board,word,newRow,newCol,i+1);
            }
            board[row][col]=temp;
        }
        return check;
    }
}