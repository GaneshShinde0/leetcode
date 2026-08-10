class Solution {
    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int row2, col2;
    private boolean isWithinFarm(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
    
    private void DFS(int[][] land, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        row2 = Math.max(row2, x); col2 = Math.max(col2, y);
        
        for (int[] dir : dirs) {
            int newX = x + dir[0], newY = y + dir[1];
            if (isWithinFarm(newX, newY, land.length, land[0].length) && !visited[newX][newY]
                    && land[newX][newY] == 1) {
                DFS(land, visited, newX, newY);
            }
        }
    }
    
    public int[][] findFarmland(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        List<int[]> ans = new ArrayList<>();
        for (int row1 = 0; row1 < land.length; row1++) {
            for (int col1 = 0; col1 < land[0].length; col1++) {
                if (land[row1][col1] == 1 && !visited[row1][col1]) {
                    row2 = 0; col2 = 0;
                    DFS(land, visited, row1, col1);
                    int[] arr = new int[] {row1, col1, row2, col2};
                    ans.add(arr);
                }
            }
        }
        return ans.stream().toArray(int[][] :: new);
    }
}
