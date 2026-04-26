class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] maxPath = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(maxPath[i][j]!=0) continue;
                maxPath[i][j] = dfs(i,j, matrix, maxPath);
                res = Math.max(maxPath[i][j],res);
            }
        }
        return res;
    }
    private int dfs(int i, int j, int[][] matrix, int[][] maxPath){
        if(maxPath[i][j]>0){
            return maxPath[i][j];
        }
        int currPath = 1;
        maxPath[i][j] = 1;
        for(int[] dir:dirs){
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if(newI<0||newJ<0||newI>=matrix.length||newJ>=matrix[0].length || matrix[newI][newJ]<=matrix[i][j]) continue;
            maxPath[newI][newJ] = dfs(newI, newJ, matrix, maxPath);
            currPath = Math.max(currPath, maxPath[newI][newJ]+maxPath[i][j]);
        }
        return maxPath[i][j]=currPath;
    }
}