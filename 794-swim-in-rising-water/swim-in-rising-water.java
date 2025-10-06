class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n=grid[0].length,res=0;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        pq.offer(new int[]{grid[0][0],0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int height = curr[0],x=curr[1],y=curr[2];
            res=Math.max(res,grid[x][y]);
            if(x==m-1&&y==n-1) return res;
            vis[x][y]=true;
            for(int[] dir:dirs){
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(nx>=m||ny>=n||nx<0||ny<0||vis[nx][ny])continue;
                pq.offer(new int[]{grid[nx][ny],nx,ny});
            }
        }
        return -1;
    }
}