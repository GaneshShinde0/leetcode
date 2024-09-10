class Solution {

    private int[][] directions = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}  
    };
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        int ptr=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if (checkAllDir(board,i,j,w,ptr)) return true;
            }
        }
        return false;
    }

    public boolean checkAllDir(char[][] board, int i, int j, char[] word, int ptr){
        if (ptr==word.length) return true;
        if (i<0 || j<0 || i == board.length || j == board[i].length) return false;
        if(board[i][j]!=word[ptr]) return false;
        board[i][j] ^=256;
        boolean exist = checkAllDir(board, i, j+1, word, ptr+1)
                        ||checkAllDir(board, i+1, j, word, ptr+1)
                        ||checkAllDir(board, i, j-1, word, ptr+1)
                        ||checkAllDir(board, i-1, j, word, ptr+1);
        board[i][j] ^=256;
        return exist;
    }
}
