class Solution {

    // All possible single-step moves on the lock pattern grid
    // Each array represents a move as {row change, column change}
    private static final int[][] SINGLE_STEP_MOVES = {
        { 0, 1 },
        { 0, -1 },
        { 1, 0 },
        { -1, 0 }, // Adjacent moves (right, left, down, up)
        { 1, 1 },
        { -1, 1 },
        { 1, -1 },
        { -1, -1 }, // Diagonal moves
        { -2, 1 },
        { -2, -1 },
        { 2, 1 },
        { 2, -1 }, // Extended moves (knight-like moves)
        { 1, -2 },
        { -1, -2 },
        { 1, 2 },
        { -1, 2 },
    };

    // Moves that require a dot to be visited in between
    // These moves "jump" over a dot, which must have been previously visited
    private static final int[][] SKIP_DOT_MOVES = {
        { 0, 2 },
        { 0, -2 },
        { 2, 0 },
        { -2, 0 }, // Straight skip moves (e.g., 1 to 3, 4 to 6)
        { -2, -2 },
        { 2, 2 },
        { 2, -2 },
        { -2, 2 }, // Diagonal skip moves (e.g., 1 to 9, 3 to 7)
    };

    public int numberOfPatterns(int m, int n) {
        int totalPatterns = 0;
        // Start from each of the 9 dots on the grid
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                boolean[][] visitedDots = new boolean[3][3];
                // Count patterns starting from this dot
                totalPatterns +=
                countPatternsFromDot(m, n, 1, row, col, visitedDots);
            }
        }
        return totalPatterns;
    }

    private int countPatternsFromDot(
        int m,
        int n,
        int currentLength,
        int currentRow,
        int currentCol,
        boolean[][] visitedDots
    ) {
        // Base case: if current pattern length exceeds n, stop exploring
        if (currentLength > n) {
            return 0;
        }

        int validPatterns = 0;
        // If current pattern length is within the valid range, count it
        if (currentLength >= m) validPatterns++;

        // Mark current dot as visited
        visitedDots[currentRow][currentCol] = true;

        // Explore all single-step moves
        for (int[] move : SINGLE_STEP_MOVES) {
            int newRow = currentRow + move[0];
            int newCol = currentCol + move[1];
            if (isValidMove(newRow, newCol, visitedDots)) {
                // Recursively count patterns from the new position
                validPatterns +=
                countPatternsFromDot(
                    m,
                    n,
                    currentLength + 1,
                    newRow,
                    newCol,
                    visitedDots
                );
            }
        }

        // Explore all skip-dot moves
        for (int[] move : SKIP_DOT_MOVES) {
            int newRow = currentRow + move[0];
            int newCol = currentCol + move[1];
            if (isValidMove(newRow, newCol, visitedDots)) {
                // Check if the middle dot has been visited
                int middleRow = currentRow + move[0] / 2;
                int middleCol = currentCol + move[1] / 2;
                if (visitedDots[middleRow][middleCol]) {
                    // If middle dot is visited, this move is valid
                    validPatterns +=
                    countPatternsFromDot(
                        m,
                        n,
                        currentLength + 1,
                        newRow,
                        newCol,
                        visitedDots
                    );
                }
            }
        }

        // Backtrack: unmark the current dot before returning
        visitedDots[currentRow][currentCol] = false;
        return validPatterns;
    }

    // Helper method to check if a move is valid
    private boolean isValidMove(int row, int col, boolean[][] visitedDots) {
        // A move is valid if it's within the grid and the dot hasn't been visited
        return (
            row >= 0 && col >= 0 && row < 3 && col < 3 && !visitedDots[row][col]
        );
    }
}