class Solution {
    public int[][] minScore(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        //sort based on the value in the grid in ascending order
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        
        // add to the grid values to the pq
        for (int i = 0;i<r;i++)
            for (int j = 0;j<c;j++)
                pq.offer(new int[]{i, j});
        
        // this will maintain the max in a row and max in a column
        int[] row_max = new int[r];
        int[] col_max = new int[c];
        
        //result matrix to store the values
        int[][] result = new int[r][c];
        
        //iterate the grid values from pq
        while(!pq.isEmpty()){
            int[] n = pq.poll();
            int i = n[0];
            int j = n[1];
            
            //result will have the row's max or col's max + 1
            result[i][j] = Math.max(row_max[i], col_max[j]) + 1;
            
            //set the rows max and cols max
            row_max[i] = result[i][j];
            col_max[j] = result[i][j];
        }
        
        return result;
    }
}