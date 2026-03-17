class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0 && matrix[i][j]!=0) matrix[i][j]=matrix[i][j]+matrix[i-1][j];
            }

            int[] row = matrix[i].clone();
            Arrays.sort(row);
            for(int j=0;j<n;j++){
                // row is sorted in increasing order, If we have row[j], then it is bound to have values greater than or equal to in next (n-j-1) rows.
                // Considering that max square would be row[j]*(n-j)
                res = Math.max(res,row[j]*(n-j));
            }
        }
        return res;
    }
}