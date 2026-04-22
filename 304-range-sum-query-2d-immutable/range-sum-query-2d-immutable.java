class NumMatrix {
    int[][] matrix1;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.matrix1 = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    this.matrix1[i][j] = matrix[i][j];
                }else{
                    this.matrix1[i][j]= matrix[i][j]+matrix1[i][j-1];
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                this.matrix1[i][j]= matrix1[i][j]+matrix1[i-1][j];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int reduce = 0;
        if(row1!=0){
            reduce+=matrix1[row1-1][col2];
        }
        if(col1!=0){
            reduce+=matrix1[row2][col1-1];
        }
        if(row1!=0 && col1!=0){
            reduce -= matrix1[row1-1][col1-1];
        }
        return matrix1[row2][col2]-reduce;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */