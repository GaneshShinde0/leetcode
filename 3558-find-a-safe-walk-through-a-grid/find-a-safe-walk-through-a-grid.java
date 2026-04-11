class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // down, right, up, left

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();         // Number of rows
        int n = grid.get(0).size();  // Number of columns

        if(grid.get(0).get(0)==1) health--;
        // BFS queue to store the position (row, col) and remaining health
        Stack<int[]> queue = new Stack<int[]>();
        queue.add(new int[]{0, 0, health}); // Start from the top-left corner with given health

        // visited matrix to store the maximum health left when visiting each cell
        int[][] maxHealth = new int[m][n];
        for (int[] row : maxHealth) {
            Arrays.fill(row, -1); // Initialize all cells as unvisited with -1 health
        }
        maxHealth[0][0] = health; // Starting cell has the initial health

        while (!queue.isEmpty()) {
            int[] current = queue.pop();
            int row = current[0];
            int col = current[1];
            int curHealth = current[2];

            // If we reach the bottom-right corner and still have at least 1 health (health > 1 after reaching), return true
            if (row == m - 1 && col == n - 1 && curHealth >= 1) {
                return true;
            }

            // Explore neighbors (down, right, up, left)
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check if the new position is within bounds
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newHealth = curHealth - grid.get(newRow).get(newCol); // reduce health if it's an unsafe cell (1)

                    // If we have positive health and it's better than the previous visit to this cell
                    if (newHealth > 0 && newHealth > maxHealth[newRow][newCol]) {
                        maxHealth[newRow][newCol] = newHealth; // update max health for this cell
                        queue.add(new int[]{newRow, newCol, newHealth});
                    }
                }
            }
        }

        // If we exit the loop, there's no valid path to the bottom-right corner with health > 1
        return false;
    }
}