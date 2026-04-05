class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    queue.add(new int[] { i, j });
                }
            }
        }
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int newI = curr[0] + dir[0];
                    int newJ = curr[1] + dir[1];
                    if (newI < 0 || newJ < 0 || newI >= m || newJ >= n || res[newI][newJ] != Integer.MAX_VALUE)
                        continue;
                    res[newI][newJ] = dist;
                    queue.add(new int[] { newI, newJ });
                }
            }
            dist++;
        }
        return res;
    }
}