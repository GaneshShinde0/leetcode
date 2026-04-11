class Solution {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int shortestPathInitial(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] vis = new boolean[m][n][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,k});
        vis[0][0][k]=true;
        int shortestDistancce = 0;
        int res = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int d = curr[2];
            int k1 = curr[3];
            if(i==m-1 && j==n-1){
                if(grid[i][j]==1 && k1<=0) continue;
                else if(grid[i][j]==0) return d;
            }
            for(int[] dir:dirs){
                int newI = i+dir[0];
                int newJ = j+dir[1];
                if(newI==m-1 && newJ==n-1){
                    if(grid[newI][newJ]==1 && k1<0) continue;
                    else if(grid[newI][newJ]==0) return d+1;
                }
                if(newI<0||newJ<0||newI>=m||newJ>=n||vis[newI][newJ][k1]) continue;
                vis[newI][newJ][k1] = true;
                int temp = k1;
                if(grid[newI][newJ]==1) temp--;
                if(temp<0)continue;
                queue.add(new int[]{newI,newJ,d+1,temp});
            }
        }
        return -1;
    }

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length, n = grid[0].length;
        if (k >= m + n - 2) return m + n - 2;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] vis = new boolean[m][n][k + 1];
        queue.add(new int[]{0, 0, k, 0});
        vis[0][0][k] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], remK = curr[2], dist = curr[3];
            if (r == m - 1 && c == n - 1) {
                return dist;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextK = remK - grid[nr][nc];
                    if (nextK >= 0 && !vis[nr][nc][nextK]) {
                        vis[nr][nc][nextK] = true;
                        queue.add(new int[]{nr, nc, nextK, dist + 1});
                    }
                }
            }
        }
        return -1;
    }
}

/*
[0,1,0,0]
[1,0,1,1]
[1,0,0,1]
[0,0,1,0]

*/