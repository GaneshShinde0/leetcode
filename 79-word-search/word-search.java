class Solution {
    private static final int[][] directions = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if(index == word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(board[row][col] != word.charAt(index)) return false;

        char temp = board[row][col];
        board[row][col] = '/';  // mark visited

        for(int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(dfs(board, word, newRow, newCol, index + 1)) {
                board[row][col] = temp;  // restore before returning
                return true;
            }
        }

        board[row][col] = temp;  // restore
        return false;
    }
}
