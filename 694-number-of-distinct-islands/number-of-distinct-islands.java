import java.util.*;

class Solution {
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int m, n;

    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, i, j, sb);
                    shapes.add(sb.toString());
                }
            }
        }
        return shapes.size();
    }

    private void dfs(int[][] grid, int i, int j, int baseI, int baseJ, StringBuilder sb) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1)
            return;

        grid[i][j] = -1;
        // record relative position
        sb.append((i - baseI) + "," + (j - baseJ));

        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], baseI, baseJ, sb);
        }
    }
}
