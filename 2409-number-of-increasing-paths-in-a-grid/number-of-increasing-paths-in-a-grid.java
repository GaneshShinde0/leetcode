class Solution {
    private static final long MOD = 1_000_000_007;
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public int countPaths(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] paths = new int[m][n];
        long totalPaths = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalPaths = (totalPaths + dfs(i, j, matrix, paths)) % MOD;
            }
        }
        return (int) totalPaths;
    }
    private int dfs(int i, int j, int[][] matrix, int[][] paths){
        if(paths[i][j]>0){
            return paths[i][j];
        }
        paths[i][j] = 1;
        long neighbourSum = 1;
        for(int[] dir:dirs){
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if(newI<0||newJ<0||newI>=matrix.length||newJ>=matrix[0].length || matrix[newI][newJ]<=matrix[i][j]) continue;
            paths[newI][newJ] = dfs(newI, newJ, matrix, paths);
            neighbourSum = (neighbourSum +paths[newI][newJ])%MOD;
        }
        return paths[i][j]=(int) neighbourSum;
    }
}