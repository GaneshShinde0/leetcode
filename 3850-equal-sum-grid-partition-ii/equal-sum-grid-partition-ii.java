class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0;
        int[] globalFreq = new int[100001];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
                globalFreq[grid[i][j]]++;
            }
        }

        // Horizontal Cuts
        int[] topFreq = new int[100001];
        int[] botFreq = globalFreq.clone();
        long currSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                currSum += val;
                topFreq[val]++;
                botFreq[val]--;
            }
            if (check(currSum, total - currSum, i, n, true, grid, topFreq, botFreq, i)) return true;
        }

        // Vertical Cuts
        int[] leftFreq = new int[100001];
        int[] rightFreq = globalFreq.clone();
        currSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                int val = grid[i][j];
                currSum += val;
                leftFreq[val]++;
                rightFreq[val]--;
            }
            if (check(currSum, total - currSum, m, j, false, grid, leftFreq, rightFreq, j)) return true;
        }

        return false;
    }

    private boolean check(long s1, long s2, int h, int w, boolean isHorizontal, int[][] grid, int[] f1, int[] f2, int cutIdx) {
        long diff = s1 - s2;
        if (diff == 0) return true;
        
        // Target element x must be |s1 - s2|
        long target = Math.abs(diff);
        if (target > 100000) return false;
        int x = (int) target;

        if (diff > 0) { // Discount from Section 1
            int rows = isHorizontal ? cutIdx + 1 : grid.length;
            int cols = isHorizontal ? grid[0].length : cutIdx + 1;
            if (rows > 1 && cols > 1) return f1[x] > 0; // Block
            // Strip: Check only the ends
            if (isHorizontal) { // Row strip (rows=1) or Col strip (cols=1)
                if (cols > 1) return grid[0][0] == x || grid[0][cols - 1] == x;
                return grid[0][0] == x || grid[rows - 1][0] == x;
            } else {
                if (rows > 1) return grid[0][0] == x || grid[rows - 1][0] == x;
                return grid[0][0] == x || grid[0][cols - 1] == x;
            }
        } else { // Discount from Section 2
            int rows = isHorizontal ? grid.length - (cutIdx + 1) : grid.length;
            int cols = isHorizontal ? grid[0].length : grid[0].length - (cutIdx + 1);
            if (rows > 1 && cols > 1) return f2[x] > 0; // Block
            if (isHorizontal) {
                if (cols > 1) return grid[grid.length - 1][0] == x || grid[grid.length - 1][cols - 1] == x;
                return grid[cutIdx + 1][0] == x || grid[grid.length - 1][0] == x;
            } else {
                if (rows > 1) return grid[0][grid[0].length - 1] == x || grid[rows - 1][grid[0].length - 1] == x;
                return grid[0][cutIdx + 1] == x || grid[0][grid[0].length - 1] == x;
            }
        }
    }
}