class Solution {
    boolean explore(int i, int j, int previous, int[] seen, int[][] grid, List<List<Integer>> path) {
        int m = grid.length;
        int n = grid[0].length;

        // out of bounds 
        if(i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }

        // already seen 
        if(seen[i * n + j] == 1) {
            return false;
        }

        // not sequential 
        if(previous + 1 != grid[i][j] && grid[i][j] != 0) {
            return false;
        }

        // sequential 
        if(previous + 1 == grid[i][j]) {
            previous = grid[i][j];
        }

        // mark seen, add path 
        seen[i * n + j] = 1; 
        path.add(List.of(i, j));

        // explore adjacent 
        for(int[] dir: new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}}) {
            explore(i + dir[0], j + dir[1], previous, seen, grid, path);

            // check if cover found 
            if(path.size() == m * n) {
                return true;
            }
        }

        // backtrack 
        seen[i * n + j] = 0;
        path.remove(path.size() - 1);

        return false;
    }


    public List<List<Integer>> findPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[] seen = new int[m * n];
        List<List<Integer>> path = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(explore(i, j, 0, seen, grid, path)) 
                    return path;
            }
        }

        return path;
    }
}