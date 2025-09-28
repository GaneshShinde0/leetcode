class Solution {
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q= new LinkedList<>();
        int x,y,res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        if(checkGrid(grid)) return res;
        while(!q.isEmpty()){
            res++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] current = q.poll();
                // System.out.println("Res: "+res+": "+Arrays.toString(current));
                for(int[] dir:directions){
                    x = current[0]+dir[0];
                    y = current[1]+dir[1];
                    // System.out.println("X: "+x+", Y: "+y);
                    if(x<0||y<0||x>=m||y>=n) continue;
                    // for(int k=0;k<m;k++){
                    //     System.out.println(Arrays.toString(visited[k]));
                    // }
                    if(!visited[x][y] && grid[x][y]==1){
                        visited[x][y]=true;
                        grid[x][y]=2;
                        q.offer(new int[]{x,y});
                    }
                    if(checkGrid(grid)) return res;
                }
            }
        }
        // for(int i=0;i<m;i++){
        //     System.out.println(Arrays.toString(grid[i]));
        // }        
        return -1;
    }

    private boolean checkGrid(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return false;
            }
        }
        return true;
    }
}