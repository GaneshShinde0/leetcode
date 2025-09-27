class Solution {
    public int[][] restoreMatrixInitial(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int[] currRowSum = new int[m];
        int[] currColSum = new int[n];

        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                res[i][j] = Math.min(rowSum[i]-currRowSum[i], colSum[j]-currColSum[j]);
                currRowSum[i]+=res[i][j];
                currColSum[j]+=res[i][j];
            }
        }
        return res;
    }
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int numrows = rowSum.length;
        int colrows = colSum.length;
        int[][] result = new int[numrows][colrows];

        int i=0,j=0;

        while(i<numrows && j<colrows){
            int val = Math.min(rowSum[i], colSum[j]);
            result[i][j] = val;
            rowSum[i] -= val;
            colSum[j] -= val;

            if(rowSum[i] == 0){
                i++;
            }
            if(colSum[j] == 0){
                j++;
            }
        }
        return result;
    }
}