class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>(9);
        List<Set<Character>> cols = new ArrayList<>(9);
        List<Set<Character>> cell = new ArrayList<>(9);
        for(int i=0;i<9;i++){
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            cell.add(new HashSet<Character>());
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(rows.get(i).contains(board[i][j])|| cols.get(j).contains(board[i][j])||  cell.get(3*(i/3)+(j/3)).contains(board[i][j])) return false;
                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                cell.get(3*(i/3)+(j/3)).add(board[i][j]);
            }
        }
        return true;
    }
}