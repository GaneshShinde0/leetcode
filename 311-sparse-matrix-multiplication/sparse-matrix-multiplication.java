class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m1 = mat1.length;
        int n1 = mat1[0].length;
        int m2 = mat2.length;
        int n2 = mat2[0].length;
        int[][] res = new int[m1][n2];
        for(int i=0;i<m1;i++){
            for(int j=0;j<n2;j++){
                for(int k=0;k<n1;k++){
                    res[i][j]+=mat1[i][k]*mat2[k][j];
                }
            }
        }
        return res;
    }
}