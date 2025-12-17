class Solution {
    private static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0) pq.add(new int[]{i,j,0});
            }
        }
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] dir:dirs){
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(nx>=m || nx<0 || ny>=n || ny<0 || rooms[nx][ny]<=rooms[x][y]+1 ||rooms[nx][ny]==0) continue;
                rooms[nx][ny]=Math.min(rooms[nx][ny],rooms[x][y]+1);
                pq.add(new int[]{nx,ny,rooms[nx][ny]});
            }
        }
    }
}