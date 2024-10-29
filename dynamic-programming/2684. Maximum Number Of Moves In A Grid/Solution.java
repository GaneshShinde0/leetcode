class Solution {
    /*
    We have a M*N Matrix called grid, filled with positive integers. The challenge is to start from any cell in the first column and find out how many moves we can make to the right while following specific rules.
    From any cell (i,j) in the first column, we can move to the next column in one of three ways:
    1. Directly right to the cell (i, j+1)
    2. Diagonally up-right to the cell (i-1,j+1)
    3. Diagonally down-right to the cell (i+1, j+1);

    However, there' an important condition: We can only make a move if the value in the destination cell is greater than the value in the current cell.

    Our goal is to determine the maximum number of moves we can make, starting from any cell in the first column.

    Approach 1: Breadth-First Search

    */

    /*
    Approach 1: Breadth-First Search
     Explore possible cells from the current cell and continue until no further options remain. This works well when there is a single starting cell.

    Time Complexity: O(m*n)
        We will always be visiting a cell only once due to the visited array. We started from the cells in the first column and might end up in visiting all the cells in the matrix. Hence the time complexity is equal to O(m*n)
    Space Complexity: O(m*n)
        We need the visited array as te size of the given matrix grid
    */
    private final int[] dirs = {-1, 0, 1};

    public int maxMovesBFS(int[][] grid){
        int m = grid.length, n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        // Enqueue the cells in the first column
        for(int i=0; i<m; i++){
            visited[i][0] = true;
            q.offer(new int[] {i,0,0});
        }

        int maxMoves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] v = q.poll();

                // Current cell with the number of moves made so far.
                int row = v[0], col = v[1], count = v[2];
                maxMoves = Math.max(maxMoves, count);
                for(int dir:dirs){
                    int newRow = row+dir, newCol = col+1;

                    if(newRow>=0 && newCol>=0 && newRow<m && newCol<n && !visited[newRow][newCol] && grid[row][col]<grid[newRow][newCol]){
                        visited[newRow][newCol] = true;
                        q.offer(new int[] { newRow, newCol, count+1});
                    }
                }
            }
        }
        return maxMoves;
    }

    /*
    // Approach 2 : Top Down Dynamic Programming
    This approach uses similar idea but with a different strategy.

    */

    private int DFS(int row, int col, int[][] grid, int[][] dp){
        int m = grid.length, n = grid[0].length;

        // If we have calculated the moves required for this cell, return the answer and skip the recursion.
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int maxMoves = 0;
        for(int dir: dirs){
            // Next cell after the move.
            int newRow = row+dir, newCol = col+1;

            // If the Next cell is valid and greater than the current cell value
            // Perform recursion to that cell with updated value of moves.

            if(newRow >= 0 &&
                newCol >= 0 &&
                newRow <m &&
                newCol <n &&
                grid[row][col]<grid[newRow][newCol]){
                    maxMoves = Math.max(maxMoves, 1+DFS(newRow, newCol, grid, dp));
                }
        }
        dp[row][col] = maxMoves;
        return maxMoves;
    }

    public int maxMovesTopDown(int[][] grid){
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        int maxMoves = 0;
        // Start DFS from each cell in the first column.
        for(int i=0;i<m;i++){
            int movesRequired = DFS(i, 0, grid, dp);
            maxMoves = Math.max(maxMoves, movesRequired);
        }

        return maxMoves;
    }

    // Approach 3 : Bottom Up
    public int maxMovesBottomUp(int[][] grid){
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        // Cells in the first column will have the moves as 1.
        // This is required to ensure we have a way if the cell is reachable or not from the first column
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        int maxMoves = 0;
        for(int j=1;j<n;j++){
            for(int i=0;i<m;i++){
                // Check all the three next possible cells
                // Check if the next cell is greater than the previous one
                // Check if the previous cell was reachable
                // If the value is >0
                if(grid[i][j]>grid[i][j-1] && dp[i][j-1]>0){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]+1);
                }

                if(i-1>=0 && grid[i][j]>grid[i-1][j-1] && dp[i-1][j-1]>0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
                }
                if(i+1<m &&
                    grid[i][j] > grid[i+1][j-1] &&
                    dp[i+1][j-1]>0
                ){
                    dp[i][j] = Math.max(dp[i][j],dp[i+1][j-1]+1);
                }
                maxMoves = Math.max(maxMoves, dp[i][j]-1);
            }
        }
        return maxMoves;
    }

    // Approach 4: Space Optimized Bottom Up Dynamic Programming
    public int maxMoves(int[][] grid){

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][2];

        // Initialize the first column cells as reachable.
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        int maxMoves = 0;

        // Iterate over each column starting from the second one.
        for(int j=1;j<n;j++){
            for(int i=0;i<m;i++){
                // Check if moving from the same row of the previous column is possible
                if(grid[i][j]>grid[i][j-1] && dp[i][0]>0){
                    dp[i][1] = Math.max(dp[i][1], dp[i][0]+1);
                }
                // Check if moving from upper diagonal is possible.
                if(i-1 >= 0 &&
                    grid[i][j]> grid[i-1][j-1] &&
                    dp[i-1][0]>0
                ){
                    dp[i][1] = Math.max(dp[i][1],dp[i-1][0]+1);
                }
                // Check if moving from the lower diagonal is possible 
                if(
                    i+1<m &&
                    grid[i][j]>grid[i+1][j-1] &&
                    dp[i+1][0]>0
                ){
                    dp[i][1] = Math.max(dp[i][1], dp[i+1][0]+1);
                }
                // Update the maximum moves so far.
                maxMoves = Math.max(maxMoves, dp[i][1]-1);
            }
            // Shift dp values for the next iteration.
            for(int k=0;k<m;k++){
                dp[k][0] = dp[k][1];
                dp[k][1] = 0;
            }
        }
        return maxMoves;
    }

}
