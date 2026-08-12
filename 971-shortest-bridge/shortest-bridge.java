class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int shortestBridge(int[][] grid) {
        List<int[]> firstSet = new ArrayList<>();
        int n = grid.length;
        for(int i=0;i<n;i++){
            boolean found = false;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(firstSet,grid, i, j, n);
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        int distance = 0;
        while(!firstSet.isEmpty()){
            List<int[]> newBFS = new ArrayList<>();
            for(int[] pair:firstSet){
                int i = pair[0], j = pair[1];
                for(int[] dir:dirs){
                    int newI = i+dir[0], newJ = j+dir[1];
                    if(newI<0||newJ<0||newI>=n||newJ>=n) continue;
                    if(grid[newI][newJ]==1){
                        return distance;
                    }else if(grid[newI][newJ]==0){
                        newBFS.add(new int[]{newI,newJ});
                        grid[newI][newJ]=-1;
                    }
                }
            }
            firstSet = newBFS;
            distance++;
        }
        return distance;
    }
    private void dfs(List<int[]> li, int[][] grid, int i, int j, int n){
        grid[i][j]=-1;
        li.add(new int[]{i,j});
        for(int[] dir:dirs){
            int newI = i+dir[0], newJ = j+dir[1];
            if(newI<0||newJ<0||newI>=n||newJ>=n) continue;
            if(grid[newI][newJ]==1) dfs(li, grid,newI,newJ,n);
        }
    }
}