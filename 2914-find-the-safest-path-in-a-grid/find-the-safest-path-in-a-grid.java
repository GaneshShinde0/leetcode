class Solution {
    static final int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if(grid.get(0).get(0)==1 || grid.get(n-1).get(n-1)==1) return 0;

        int[][] arr = new int[n][n];

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = grid.get(i).get(j);
                if(arr[i][j]==1) q.add(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int i = curr[0], j= curr[1];
            int v = arr[i][j];

            for(int[] dir: dirs){
                int x = i + dir[0];
                int y = j + dir[1];
                if(x<0||y<0||x>=n||y>=n||arr[x][y]!=0) continue;
                arr[x][y] = v+1;
                q.add(new int[]{x,y});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[0],a[0]));
        pq.add(new int[]{arr[0][0], 0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int dist = curr[0];
            int i = curr[1], j = curr[2];
            if(i==n-1 && j==n-1) return dist - 1;

            for(int[] dir:dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                if(x<0||y<0||x>=n||y>=n||arr[x][y]<=0) continue;
                pq.add(new int[]{Math.min(dist, arr[x][y]), x, y});
                arr[x][y] *= -1;
            }
        }

        return arr[n - 1][n - 1] - 1;
    }
}