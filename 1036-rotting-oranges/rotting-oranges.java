class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int minutes = -1;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) queue.add(new int[]{i,j});
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0;k<size;k++){
                int[] curr = queue.poll();
                int i = curr[0],j=curr[1];
                for(int[] dir:dirs){
                    int newI = i+dir[0], newJ = j+dir[1];
                    if(newI<0||newJ<0||newI>=m||newJ>=n||grid[newI][newJ]!=1) continue;
                    grid[newI][newJ]=2;
                    queue.add(new int[]{newI,newJ});
                }
            }
            minutes++;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return Math.max(minutes,0);
    }
}