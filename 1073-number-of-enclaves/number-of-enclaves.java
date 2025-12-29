class Solution {
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numEnclaves(int[][] grid) {
        Stack<int[]> q = new Stack<>();
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                q.add(new int[]{i,0});
                grid[i][0] = 0; // Mark visited immediately
            }
            if(grid[i][n-1]==1){
                q.add(new int[]{i,n-1});
                grid[i][n-1] = 0; // Mark visited immediately
            }
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                q.add(new int[]{0,i});
                grid[0][i] = 0; // Mark visited immediately
            }
            if(grid[m-1][i]==1){
                q.add(new int[]{m-1,i});
                grid[m-1][i] = 0; // Mark visited immediately
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.pop();
            int x = curr[0];
            int y = curr[1];
            for(int[] dir:dirs){
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(nx<0||ny<0||nx>=m||ny>=n||grid[nx][ny]==0) continue;
                grid[nx][ny]=0;
                q.push(new int[]{nx,ny});
            }
        }
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) res++;
            }
        }
        return res;

    }
}