class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length,i=0;
        for(;i<m;i++){
            if(matrix[i][0]<=target && matrix[i][n-1]>=target) break;
        }
        if(i==m) return false;
        for(int j=0;j<n;j++){
            if(matrix[i][j]==target) return true;
        }
        return false;
    }
}