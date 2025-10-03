/*

Intuition:

The problem can be visualized as filling water in a 2D elevation map. Imagine boundaries as walls that hold water, and the height of the walls determines how much water can be trapped. By using a priority queue (min heap, we simulate this process. Stating from the lowest boundary and working inward, while markingg calls as visited to avoid reprocessing.)

Approach:

1. Boundary Initialization
- Add all boundary cells into a min-heap with their heights. These boundaries define the limit of water trapping.
- Mark boundary cells as visited using a 2D array to prevent redundant processing.

2. Process Cells from the Min-Heap
- Extract the cells with the smallest height from the heap.
- For each of its neighboring cells:
    - Calculate the trapped water:
        - waterTrapped +=Max(0, currentHeight-neighborHeight)
    - Update the neighbor's height to the larger of its own height or the current height, simulating water filling.
    - Push the updated neighbor into the heap and mark it as visited.

3. Repeat until heap is Empty:
    - Continue the process for cells in the heap until no more cells are left.

4. Return the result:
    - The accumulated water is returned as the result.

Complexity:
    - Time:
        - Each cell is processed once, heap takes O(log(m*n));
        - m*n(log(m*n))
    - Space Complexity
        - O(m*n)
*/


// Very Easy
class Solution {
    public int trapRainWater(int[][] heightMap){
        if(heightMap == null || heightMap.length==0 || heightMap[0].length==0) return 0;

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        // Add boundary cells
        for(int i=0;i<m;i++){
            for(int j:new int[]{0,n-1}){
                minHeap.offer(new int[]{heightMap[i][j], i, j});
                visited[i][j]= true;
            }
        }

        for(int j=0;j<n;j++){
            for(int i:new int[]{0,m-1}){
                minHeap.offer(new int[]{heightMap[i][j], i, j});
                visited[i][j]= true;
            }
        }
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int waterTrapped = 0;

        // Process cells using Min Heap
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int height = curr[0];
            int x = curr[1];
            int y = curr[2];

            for(int[] dir:dirs){
                int nx = x+dir[0], ny = y+dir[1];
                if(nx>=0 &&ny>=0 && nx<m && ny<n && !visited[nx][ny]){
                    // Calculate Water Trapped
                    waterTrapped+=Math.max(0,height-heightMap[nx][ny]);
                    minHeap.offer(new int[]{Math.max(height, heightMap[nx][ny]), nx,ny});
                    visited[nx][ny]=true;
                }
            }
        }
        return waterTrapped;
    }

}



    // Older Solution.
    // Solve like trapping rain water but consider four directions instead of two.
//     Why this may fail / be incorrect

// This method computes the maximum barrier height from each direction independently, not taking into account interactions. For example, a cell might think there is a tall barrier on the left and tall on the right, but those barriers may not connect or block water in 2D (they might be disconnected paths). So water may “leak” via another direction that is lower.
    // public int trapRainWater(int[][] heightMap) {
    //     int n = heightMap[0].length;
    //     int m = heightMap.length;
    //     int[][] leftHeight = new int[m][n];
    //     int[][] rightHeight = new int[m][n];
    //     int[][] up = new int[m][n];
    //     int[][] down = new int[m][n];
    //     int res = 0;
    //     leftHeight[0]=height[0];
    //     rightHeight[n-1]=height[n-1];
    //     for(int j=0;j<m;j++){
    //         for(int i=1;i<n;i++){
    //             leftHeight[i]=Math.max(heightMap[i],leftHeight[i-1]);
    //             rightHeight[n-i-1]=Math.max(heightMap[n-i-1],rightHeight[n-i]);
    //         }
    //     }
    //     for(int i=0;i<n;i++){
    //         res+=Math.min(leftHeight[i],rightHeight[i])-height[i];
    //     }
    //     return res;
    // }