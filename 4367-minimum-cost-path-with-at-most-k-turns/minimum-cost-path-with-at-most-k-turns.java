class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][][] dist = new int[m][n][k + 1][4];
        for (int[][][] a : dist)
            for (int[][] b : a)
                for (int[] c : b) Arrays.fill(c, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int start = grid[0][0];
        for (int d = 0; d < 4; d++) {
            dist[0][0][0][d] = start;
            pq.add(new int[]{start, 0, 0, 0, d});
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], i = cur[1], j = cur[2], turns = cur[3], dir = cur[4];

            if (cost > dist[i][j][turns][dir]) continue; // skip stale entries
            if (i == m - 1 && j == n - 1) return cost;

            for (int d = 0; d < 4; d++) {
                int ni = i + dirs[d][0], nj = j + dirs[d][1];
                if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;

                int nturns = (d == dir) ? turns : turns + 1;
                if (nturns > k) continue;

                int ncost = cost + grid[ni][nj];
                if (ncost < dist[ni][nj][nturns][d]) {
                    dist[ni][nj][nturns][d] = ncost;
                    pq.add(new int[]{ncost, ni, nj, nturns, d});
                }
            }
        }
        return -1;
    }
}
class SolutionUsingObject{
    class Position{
        public int i,j,cost,k,prevDir;
        public Position(int i, int j, int cost, int k, int prevDir){
            this.i = i;
            this.j = j;
            this.cost = cost;
            this.k = k;
            this.prevDir = prevDir;
        }
    }
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        
        int[][][][] dist = new int[m][n][k+1][4];
        for(int[][][] a:dist){
            for(int[][] b:a){
                for(int[] c:b) Arrays.fill(c,Integer.MAX_VALUE/4);
            }
        }
        PriorityQueue<Position> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.cost,b.cost);
        });
        pq.add(new Position(0,0,grid[0][0],0,0));
        pq.add(new Position(0,0,grid[0][0],0,1));
        pq.add(new Position(0,0,grid[0][0],0,2));
        pq.add(new Position(0,0,grid[0][0],0,3));
        while(!pq.isEmpty()){
            Position curr = pq.poll();
            if(curr.i==m-1 && curr.j==n-1){
                return curr.cost;
            }
            for(int i=0;i<4;i++){
                int newI = curr.i+dirs[i][0];
                int newJ = curr.j+dirs[i][1];
                if(newI<0||newJ<0||newI>=m||newJ>=n||dist[newI][newJ][curr.k][i]<=curr.cost+grid[newI][newJ]) continue;
                if(curr.prevDir==i){
                    pq.add(new Position(newI, newJ, curr.cost+grid[newI][newJ],curr.k,i));
                    dist[newI][newJ][curr.k][i] = curr.cost+grid[newI][newJ];
                }else if(curr.k<k && dist[newI][newJ][curr.k+1][i]>curr.cost+grid[newI][newJ]){
                    pq.add(new Position(newI, newJ, curr.cost+grid[newI][newJ],curr.k+1,i));
                    dist[newI][newJ][curr.k+1][i] = curr.cost+grid[newI][newJ];
                }
            }
        }
        return -1;
    }
}