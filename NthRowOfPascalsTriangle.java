class NthRowOfPascalsTriangle {
    //takes 1 ms
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalsTriangle = generate(rowIndex+1);
        return pascalsTriangle.get(rowIndex);
    }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        row.add(1);
        pascalsTriangle.add(row);
        for(int i=1; i<numRows;i++){
            row = new ArrayList<>();
            row.add(1);
            prev = pascalsTriangle.get(i-1);
            for (int j=1;j<i;j++){
                row.add(prev.get(j-1)+prev.get(j));
            }
            row.add(1);
            pascalsTriangle.add(row);
        }
        return pascalsTriangle;
    }

    public List<Integer> getRow0Ms(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        if(rowIndex == 0){
            row.add(1);
            return row;
        }else {
            row.add(1);
            List<Integer> preRow = getRow(rowIndex - 1);
            for(int i=1; i<rowIndex; i++){
                row.add(preRow.get(i-1) + preRow.get(i));
            }
            row.add(1);
            return row;
        }

    }
}
