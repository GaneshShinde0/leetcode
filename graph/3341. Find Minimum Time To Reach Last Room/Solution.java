import java.util.PriorityQueue;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        
        // Directions for moving up, down, left, right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Priority Queue to process cells by their minimum reach time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0}); // start at (0, 0) with time 0
        
        // Array to store the minimum time to reach each cell
        int[][] time = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                time[i][j] = Integer.MAX_VALUE;
            }
        }
        time[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int t = curr[2];
            
            // If we've reached the bottom-right corner, return the time
            if (x == n - 1 && y == m - 1) {
                return t;
            }
            
            // Process all four directions
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                // Check if within bounds
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int waitTime = Math.max(moveTime[nx][ny]+1, t + 1);
                    
                    // If this new time is less than previously recorded time, update and add to queue
                    if (waitTime < time[nx][ny]) {
                        time[nx][ny] = waitTime;
                        pq.offer(new int[]{nx, ny, waitTime});
                    }
                }
            }
        }
        
        // If we exit the loop without returning, there was no valid path (shouldn't happen per constraints)
        return -1;
    }
}
