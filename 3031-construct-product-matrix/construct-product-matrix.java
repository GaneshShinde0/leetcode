class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long product = 1;
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j] = (int) (product%12345);
                product=(product*grid[i][j])%12345;
            }
        }
        long suffixProd = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                res[i][j]=(int) ((res[i][j]*suffixProd)%12345);
                suffixProd = (suffixProd*grid[i][j])%12345;
            }
        }
        return res;
    }
}