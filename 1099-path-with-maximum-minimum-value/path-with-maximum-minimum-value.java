class UF {

    // root for recording all the roots.
    private int[] root;
    private int[] rank;

    public UF(int R, int C) {
        rank = new int[R * C];
        root = new int[R * C];
        for (int i = 0; i < root.length; ++i) root[i] = i;
    }

    // Find the root of x.
    public int find(int x) {
        if (x != root[x]) root[x] = find(root[x]);
        return root[x];
    }

    // union the roots of x and y.
    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }
}

class Solution {

    // 4 directions to a cell's possible neighbors.
    private int[][] dirs = new int[][] {
        { 1, 0 },
        { -1, 0 },
        { 0, 1 },
        { 0, -1 },
    };

    public int maximumMinimumPath(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        // Sort all the cells by their values.
        List<int[]> vals = new ArrayList<>();

        // Intialize the root of all the cells and mark
        // all the cells as false (unvisited).
        boolean[][] visited = new boolean[R][C];

        // Root of all the R * C cells
        UF uf = new UF(R, C);

        // Intialize the root of all the cells.
        for (int row = 0; row < R; ++row) for (
            int col = 0;
            col < C;
            ++col
        ) vals.add(new int[] { row, col });

        // Sort all the cells by values from large to small.
        Collections.sort(vals, (gridA, gridB) -> {
            return grid[gridB[0]][gridB[1]] - grid[gridA[0]][gridA[1]];
        });

        // Iteration over the sorted cells.
        for (int[] curGrid : vals) {
            int curRow = curGrid[0], curCol = curGrid[1];
            int curPos = curRow * C + curCol;

            // Mark the current cell as visited.
            visited[curRow][curCol] = true;
            for (int[] dir : dirs) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                int newPos = newRow * C + newCol;

                // Check if the current cell has any unvisited neighbors
                // with value larger than or equal to val.
                if (
                    newRow >= 0 &&
                    newRow < R &&
                    newCol >= 0 &&
                    newCol < C &&
                    visited[newRow][newCol] == true
                ) {
                    // If so, we connect the current cell with this neighbor.
                    uf.union(curPos, newPos);
                }
            }

            // Check if the top-left cell is connected with the bottom-right cell.
            if (uf.find(0) == uf.find(R * C - 1)) {
                // If so, return the value of the current cell.
                return grid[curRow][curCol];
            }
        }
        return -1;
    }
}