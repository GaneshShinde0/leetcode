class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long total = 0;

        HashMap<Long, Integer> bottom = new HashMap<>();
        HashMap<Long, Integer> top = new HashMap<>();
        HashMap<Long, Integer> left = new HashMap<>();
        HashMap<Long, Integer> right = new HashMap<>();

        // Initialize bottom and right maps
        for (int[] row : grid) {
            for (int x : row) {
                total += x;
                bottom.put((long)x, bottom.getOrDefault((long)x, 0) + 1);
                right.put((long)x, right.getOrDefault((long)x, 0) + 1);
            }
        }

        long sumTop = 0;

        // Horizontal cuts
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                sumTop += val;

                top.put((long)val, top.getOrDefault((long)val, 0) + 1);
                bottom.put((long)val, bottom.get((long)val) - 1);
            }

            long sumBottom = total - sumTop;

            if (sumTop == sumBottom) return true;

            long diff = Math.abs(sumTop - sumBottom);

            if (sumTop > sumBottom) {
                if (check(top, grid, 0, i, 0, n - 1, diff)) return true;
            } else {
                if (check(bottom, grid, i + 1, m - 1, 0, n - 1, diff)) return true;
            }
        }

        long sumLeft = 0;

        // Vertical cuts
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                int val = grid[i][j];
                sumLeft += val;

                left.put((long)val, left.getOrDefault((long)val, 0) + 1);
                right.put((long)val, right.get((long)val) - 1);
            }

            long sumRight = total - sumLeft;

            if (sumLeft == sumRight) return true;

            long diff = Math.abs(sumLeft - sumRight);

            if (sumLeft > sumRight) {
                if (check(left, grid, 0, m - 1, 0, j, diff)) return true;
            } else {
                if (check(right, grid, 0, m - 1, j + 1, n - 1, diff)) return true;
            }
        }

        return false;
    }

    private boolean check(HashMap<Long, Integer> mp, int[][] grid,
                          int r1, int r2, int c1, int c2, long diff) {

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        // single cell
        if (rows * cols == 1) return false;

        // 1D row
        if (rows == 1) {
            return grid[r1][c1] == diff || grid[r1][c2] == diff;
        }

        // 1D column
        if (cols == 1) {
            return grid[r1][c1] == diff || grid[r2][c1] == diff;
        }

        return mp.getOrDefault(diff, 0) > 0;
    }
}
class Solution1 {
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