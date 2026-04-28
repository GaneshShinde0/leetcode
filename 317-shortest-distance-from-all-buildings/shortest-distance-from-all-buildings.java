class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    int rows,cols;
    int[][] grid;
    int totalHouses;
    public int shortestDistance(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        int minimumDistance = Integer.MAX_VALUE;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1) totalHouses++;
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0){
                    minimumDistance = Math.min(minimumDistance, bfs(i, j));
                }
            }
        }
        return minimumDistance==Integer.MAX_VALUE?-1:minimumDistance;
    }
    private int bfs(int row, int col){
        int distanceSum = 0;
        int housesReached = 0;
        boolean[][] vis = new boolean[rows][cols];
        vis[row][col] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        int steps = 0;
        while(!queue.isEmpty() && housesReached!=totalHouses){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                row = curr[0];
                col = curr[1];

                if(grid[row][col]==1){
                    distanceSum+=steps;
                    housesReached++;
                    continue;
                }

                for(int[] dir:dirs){
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];
                    if(newRow<0||newCol<0||newRow>=rows||newCol>=cols||vis[newRow][newCol]) continue;
                    if(grid[newRow][newCol]!=2){
                        vis[newRow][newCol] = true;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
            steps++;
        }
        // Find the min distance sum for each empty cell.
        if (housesReached != totalHouses) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 0 && vis[i][j]) {
                        grid[i][j] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        return distanceSum;
    }
}