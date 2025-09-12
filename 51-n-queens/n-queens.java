class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>(); 
        Set<Integer> posDiag = new HashSet<>(); // r + c
        Set<Integer> negDiag = new HashSet<>(); // r - c

        List<List<String>> res = new ArrayList<>();
        
        // Use char[][] for the board representation
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        backtrack(0, n, board, cols, posDiag, negDiag, res);
        return res;
    }

    private void backtrack(int row, int n, char[][] board, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> res) {
        if(row == n){
            List<String> copy = new ArrayList<>();
            for(int i = 0; i < n; i++){
                copy.add(new String(board[i]));
            }
            res.add(copy);
            return;
        }

        for(int col = 0; col < n; col++){
            if(cols.contains(col) || posDiag.contains(row + col) || negDiag.contains(row - col)) continue;
            
            // Place the queen
            board[row][col] = 'Q';
            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);
            
            backtrack(row + 1, n, board, cols, posDiag, negDiag, res);
            
            // Remove the queen (backtrack)
            board[row][col] = '.';
            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
        }
    }

    public List<List<String>> solveNQueensUsingString(int n) {
        Set<Integer> cols = new HashSet<>(); 
        Set<Integer> posDiag = new HashSet<>(); // r+c
        Set<Integer> negDiag = new HashSet<>(); // r-c

        List<List<String>> res = new ArrayList<>();
        List<List<String>> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            board.add(new ArrayList<>(Collections.nCopies(n,".")));
        }
        backtrack(0, n, board, cols, posDiag, negDiag, res);
        return res;
    }

    private void backtrack(int row, int n, List<List<String>> board, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> res) {
        if(row == n){
            List<String> copy = new ArrayList<>();
            for(List<String> list:board){
                copy.add(String.join("",list));
            }
            res.add(copy);
            return;
        }

        for(int col=0;col<n;col++){
            if(cols.contains(col) || posDiag.contains(row+col) || negDiag.contains(row-col)) continue;
            cols.add(col);
            posDiag.add(row+col);
            negDiag.add(row-col);
            board.get(row).set(col,"Q");
            backtrack(row+1, n, board, cols, posDiag, negDiag, res);
            board.get(row).set(col, ".");
            cols.remove(col);
            posDiag.remove(row+col);
            negDiag.remove(row-col);
        }
    }
}