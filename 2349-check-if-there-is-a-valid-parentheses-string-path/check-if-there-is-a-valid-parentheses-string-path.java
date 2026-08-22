class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 } };
    int m, n;
    Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new Boolean[m+n][m][n];
        return dfs(0, 0, 0, grid);
    }

    private boolean dfs(int score, int i, int j, char[][] grid) {
        if (i >= grid.length || j >= grid[0].length) return false;
        score += grid[i][j] == '(' ? 1 : -1;
        if(score<0) return false;
        if(memo[score][i][j]!=null) return memo[score][i][j];
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if (score == 0) return true;
            else return false;
        } else {
            memo[score][i][j] = false;
            if(i+1 < grid.length){
                memo[score][i][j] |= dfs(score, i + 1, j, grid);
            }
            if(j+1 < grid[0].length){
                memo[score][i][j] |= dfs(score, i, j + 1, grid);
            }
            return memo[score][i][j];
        }
    }
}
