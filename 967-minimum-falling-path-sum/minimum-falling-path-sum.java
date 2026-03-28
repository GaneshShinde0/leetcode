class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[n];
        for(int i=0;i<n;i++) res[i]=matrix[0][i];
        for(int i=1;i<m;i++){
            int[] temp = new int[n];
            for(int col=0;col<n;col++){
                int min = matrix[i][col]+res[col];
                for(int j=col-1;j<=col+1;j++){
                    if(j<0||j>=n) continue;
                    min = Math.min(min,matrix[i][col]+res[j]);
                }
                temp[col]=min;
            }
            res = temp;
        }
        int minSum = Integer.MAX_VALUE;
        for(int i:res) minSum = Math.min(minSum, i);
        return minSum;
    }
}