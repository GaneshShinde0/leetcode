class Solution {
    int[][] dirs = {{0,1},{1,0}};
    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] maxCurrentHealth = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(maxCurrentHealth[i], Integer.MIN_VALUE);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(b[2],a[2]));
        queue.add(new int[]{0,0,grid[0][0],grid[0][0]});
        int res = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            if(maxCurrentHealth[i][j]>=curr[3]) continue;
            maxCurrentHealth[i][j]=curr[3];
            if(i==m-1 && j==n-1){
                if(curr[2]>0) return 1;
                else return 1-curr[2];
            }
            for(int[] dir:dirs){
                int newI = i+dir[0];
                int newJ = j+dir[1];
                if(newI>=m||newJ>=n) continue;
                int currScore = curr[3]+grid[newI][newJ];
                queue.add(new int[]{newI, newJ, Math.min(curr[2], currScore), currScore});
            }
        }
        return 1;
    }
}