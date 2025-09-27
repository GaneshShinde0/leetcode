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

    public int[][] restoreMatrixSpaceComplexityGreedy(int[] rowSum, int[] colSum) {
        int N = rowSum.length;
        int M = colSum.length;

        int[][] origMatrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                origMatrix[i][j] = Math.min(rowSum[i], colSum[j]);

                rowSum[i] -= origMatrix[i][j];
                colSum[j] -= origMatrix[i][j];
            }
        }
        return origMatrix;
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