class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = false, isFirstColZero = false;
        int m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) isFirstColZero = true;
        }
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0) isFirstRowZero = true;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0||matrix[0][j]==0) matrix[i][j] = 0;
            }
        }
        if(isFirstRowZero){
            for(int j=0;j<n;j++) matrix[0][j] = 0;
        }
        if(isFirstColZero){
            for(int i=0;i<m;i++) matrix[i][0] = 0;
        }
    }
}