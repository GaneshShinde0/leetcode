class Solution {
    public boolean searchMatrixInitial(int[][] matrix, int target) {
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

    
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bot = matrix.length - 1;

        while (top <= bot) {
            int mid = (top + bot) / 2;

            if (matrix[mid][0] < target && matrix[mid][matrix[mid].length - 1] > target) {
                break;
            } else if (matrix[mid][0] > target) {
                bot = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        int row = (top + bot) / 2;

        int left = 0;
        int right = matrix[row].length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;        
    }
}