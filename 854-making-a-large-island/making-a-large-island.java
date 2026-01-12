class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int largestIsland(int[][] grid) {
        int islandId = 2;
        int m = grid.length, n = grid[0].length;
        Map<Integer, Integer> idToArea = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    int currArea = dfs(grid, i, j, islandId,m,n);
                    idToArea.put(islandId,currArea);
                    islandId++;
                }
            }
        }
        int res = 0;
        for(int i=0;i<m;i++){
            System.out.println(Arrays.toString(grid[i]));
            for(int j=0; j<n; j++){
                if(grid[i][j]==0){
                    int sum = 1;
                    Set<Integer> visited = new HashSet<>();
                    for(int[] dir:dirs){
                        int nx = i+dir[0];
                        int ny = j+dir[1];
                        if(nx<0||ny<0||nx>=m||ny>=n||grid[nx][ny]==0||visited.contains(grid[nx][ny])) continue;
                        visited.add(grid[nx][ny]);
                        sum+=idToArea.get(grid[nx][ny]);
                    }
                    res = Math.max(sum,res);
                }
            }
        }
        return res==0?(m*n):res;
    }

    private int dfs(int[][] grid, int i, int j, int islandId, int m, int n){
        grid[i][j]=islandId;
        int currArea=1;
        for(int[] dir:dirs){
            int nx = i+dir[0];
            int ny = j+dir[1];
            if(nx<0||ny<0||nx>=m||ny>=n||grid[nx][ny]!=1) continue;
            currArea+=dfs(grid, nx, ny, islandId,m,n);
        }
        return currArea;
    }
}