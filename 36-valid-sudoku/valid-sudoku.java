class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];
        for(int i=0;i<n;i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.') continue;
                char val = board[i][j];
                int boxIndex = (i/3)*3+j/3;
                if(rows[i].contains(val)||cols[j].contains(val)||boxes[boxIndex].contains(val)) return false;
                rows[i].add(val);
                cols[j].add(val);
                boxes[boxIndex].add(val);
            }
        }

        return true;
    }
}