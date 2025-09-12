class Solution {
    public List<List<String>> solveNQueens(int n) {
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