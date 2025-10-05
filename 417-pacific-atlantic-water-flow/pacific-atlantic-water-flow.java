class Solution {
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    // public List<List<Integer>> pacificAtlantic(int[][] heights) {
    //     Set<List<Integer>> res = new HashSet<>();

    //     int m = heights.length;
    //     int n = heights[0].length;
    //     char[][] pacOrAtOcean = new char[m][n];
    //     for(int i=0;i<m;i++){
    //         pacOrAtOcean[i][0]='p';
    //         pacOrAtOcean[i][n-1]='a';
    //     }
    //     for(int j=0;j<n;j++){
    //         pacOrAtOcean[0][j]='p';
    //         pacOrAtOcean[m-1][j]='a';
    //     }
    //     pacOrAtOcean[0][n-1]='b';
    //     pacOrAtOcean[m-1][0]='b';

    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(pacOrAtOcean[i][j]=='b') res.add(Arrays.asList(i,j));
    //             dfs(heights,pacOrAtOcean, i,j,res);
    //         }
    //     }
    //     return new ArrayList<>(res);
        
    // }
    // private void dfs(int[][]heights, char[][] pacOrAtOcean,int i, int j,Set<List<Integer>> res){
    //     for(int[] dir:directions){
    //         int ni=i+dir[0];
    //         int nj=j+dir[1];
    //         if(ni<0||nj<0||ni>=heights.length||nj>=heights[0].length||pacOrAtOcean[ni][nj]=='b') continue;
    //         if(heights[ni][nj]>=heights[i][j]) {
    //             if(pacOrAtOcean[ni][nj]=='p'&&pacOrAtOcean[i][j]=='a')pacOrAtOcean[i][j]='b';
    //             else if(pacOrAtOcean[ni][nj]=='a'&&pacOrAtOcean[i][j]=='p')pacOrAtOcean[i][j]='b';
    //             else pacOrAtOcean[ni][nj] = pacOrAtOcean[i][j];
    //         }
    //         if(pacOrAtOcean[ni][nj]=='b') res.add(Arrays.asList(ni,nj));
    //         // dfs(heights,pacOrAtOcean,ni,nj,res);
    //     }
    // }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        // Pacific 
        for(int i=0;i<m;i++)dfs(heights,pac,i,0,heights[i][0]);
        for(int j=0;j<n;j++)dfs(heights,pac,0,j,heights[0][j]);

        // Atlanic 
        for(int i=0;i<m;i++)dfs(heights,atl,i,n-1,heights[i][n-1]);
        for(int j=0;j<n;j++)dfs(heights,atl,m-1,j,heights[m-1][j]);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(atl[i][j]&&pac[i][j]) res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prev){
        if(i<0||j<0||i>=heights.length||j>=heights[0].length||visited[i][j]||heights[i][j]<prev) return;
        visited[i][j]=true;
        for(int[] dir:dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];
            dfs(heights,visited, ni, nj, heights[i][j]);
        }
    }
}