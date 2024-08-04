class PascalsTriangle {
    public List<List<Integer>> generate1MS(int numRows) {
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
    //Optimized solutio takes 1 ms
    public List<List<Integer>> generate1ms(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        if (numRows == 0) return pascalsTriangle;
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1); // First and last elements are always 1
                } else {
                    row.add(pascalsTriangle.get(i - 1).get(j - 1) + pascalsTriangle.get(i - 1).get(j));
                }
            }
            pascalsTriangle.add(row);
        }
        
        return pascalsTriangle;
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
}
