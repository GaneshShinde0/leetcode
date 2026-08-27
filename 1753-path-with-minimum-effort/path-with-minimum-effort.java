class Solution {
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->Integer.compare(a[2],b[2]));
        boolean[][] visited = new boolean[m][n];
        pq.add(new int[]{0,0,0,heights[0][0]});
        int maxEffort = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], diff = curr[2];
            maxEffort = Math.max(maxEffort, diff);
            // System.out.println(Arrays.toString(curr));
            if(row==m-1 && col == n-1) return maxEffort;
            for(int[] dir:dirs){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                if(newRow>=m||newCol>=n||newRow<0||newCol<0||visited[newRow][newCol]) continue;
                pq.add(new int[]{newRow, newCol, Math.abs(heights[row][col]-heights[newRow][newCol])});
            }
            visited[row][col]=true;
        }
        return maxEffort;
    }
}