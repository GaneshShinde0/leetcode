class TicTacToe {
    int n;
    List<HashSet<Integer>> rowsP1;
    List<HashSet<Integer>> rowsP2;
    List<HashSet<Integer>> colsP1;
    List<HashSet<Integer>> colsP2;
    
    HashSet<Integer> posDiagP1;
    HashSet<Integer> posDiagP2;
    HashSet<Integer> negDiagP1;
    HashSet<Integer> negDiagP2;
    public TicTacToe(int n) {
        this.n = n;
        rowsP1 = getList(n);
        colsP1 = getList(n);
        rowsP2 = getList(n);
        colsP2 = getList(n);
        posDiagP1 = new HashSet<>();
        posDiagP2 = new HashSet<>();
        negDiagP1 = new HashSet<>();
        negDiagP2 = new HashSet<>();
    }
    private List<HashSet<Integer>> getList(int n){
        List<HashSet<Integer>> temp = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            temp.add(new HashSet<Integer>());
        }
        return temp;
    }
    
    public int move(int row, int col, int player) {
        if(player == 1){
            rowsP1.get(row).add(col);
            colsP1.get(col).add(row);
            
            if(row==col) posDiagP1.add(row);
            if(Math.abs(row+col)==(n-1)) negDiagP1.add(row);
            if(rowsP1.get(row).size()==n) return 1;
            if(colsP1.get(col).size()==n) return 1;
            if(posDiagP1.size()==n||negDiagP1.size()==n) return 1;

        }else{
            rowsP2.get(row).add(col);
            colsP2.get(col).add(row);
            if(rowsP2.get(row).size()==n) return 2;
            if(colsP2.get(col).size()==n) return 2;
            if(row==col) posDiagP2.add(row);
            if(Math.abs(row+col)==(n-1)) negDiagP2.add(row);
            if(posDiagP2.size()==n||negDiagP2.size()==n) return 2;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */