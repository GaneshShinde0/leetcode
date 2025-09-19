class Spreadsheet {
    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[26][rows+1];
    }
    
    public void setCell(String cell, int value) {
        sheet[cell.charAt(0)-'A'][Integer.parseInt(cell.substring(1))] = value;     
    }
    
    public void resetCell(String cell) {
        sheet[cell.charAt(0)-'A'][Integer.parseInt(cell.substring(1))] = 0;             
    }
    
    public int getValue(String formula) {
        formula = formula.replace("=","");
        String[] cells = formula.split("\\+");
        int n = cells.length;
        int[] intCells = new int[n];
        int res = 0;
        for(int i=0;i<n;i++){
            if(cells[i].charAt(0)>='0' && cells[i].charAt(0)<='9'){
                intCells[i]= Integer.parseInt(cells[i]);
            }else{
                intCells[i] = sheet[cells[i].charAt(0)-'A'][Integer.parseInt(cells[i].substring(1))];
            }
            res+=intCells[i];
        }
        return res;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */