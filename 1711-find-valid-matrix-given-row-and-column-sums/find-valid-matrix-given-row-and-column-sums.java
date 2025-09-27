class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
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
}