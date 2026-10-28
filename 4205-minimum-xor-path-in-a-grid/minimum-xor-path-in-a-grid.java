class Solution {
    int[][] dirs = {{0,1},{1,0}};
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length, xor = 0, res = 1024, max = 1024;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,grid[0][0]});
        boolean[][][] memo = new boolean[m][n][max];
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i= curr[0], j = curr[1], currXor = curr[2];
            if(i==m-1 && j==n-1){
                res = Math.min(currXor,res);
                continue;
            }
            if(!memo[i][j][currXor]){
                if(i+1<m) queue.add(new int[]{i+1,j, currXor^grid[i+1][j]});
                if(j+1<n) queue.add(new int[]{i,j+1, currXor^grid[i][j+1]});
            }
            memo[i][j][currXor] = true;
        }
        return res;
    }
}