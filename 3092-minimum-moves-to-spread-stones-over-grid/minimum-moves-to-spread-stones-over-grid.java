class Solution {
    public int minimumMoves(int[][] grid) {
        List<int[]> sources = new ArrayList<>();
        List<int[]> targets = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) {
                    for (int c = 0; c < grid[i][j] - 1; c++) {
                        sources.add(new int[]{i, j});
                    }
                } else if (grid[i][j] == 0) {
                    targets.add(new int[]{i, j});
                }
            }
        }
        
        int n = sources.size(); // equals targets.size()
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == Integer.MAX_VALUE) continue;
            int i = Integer.bitCount(mask); // next source index to place
            if (i >= n) continue;
            
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) continue; // target j already used
                int dist = Math.abs(sources.get(i)[0] - targets.get(j)[0])
                         + Math.abs(sources.get(i)[1] - targets.get(j)[1]);
                int newMask = mask | (1 << j);
                dp[newMask] = Math.min(dp[newMask], dp[mask] + dist);
            }
        }
        
        return dp[(1 << n) - 1];
    }
}
class SolutionUsingRecursion{
    public int minimumMoves(int[][] grid) {
        int unbalanced = checkBalanced(grid);
        if(unbalanced ==0) return 0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j]>1){
                    grid[i][j]--;
                    for(int k=0;k<3;k++){
                        for(int l=0;l<3;l++){
                            if(grid[k][l]==0){
                                int d = Math.abs(i-k)+Math.abs(j-l);
                                grid[k][l]++;
                                res = Math.min(res,d+minimumMoves(grid));
                                grid[k][l]--;
                            }
                        }
                    }
                    grid[i][j]++;
                }
            }
        }
        return res;
    }
    private int checkBalanced(int[][] grid){
        int unbalanced = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                unbalanced += Math.max(grid[i][j]-1,0);
            }
        }
        return unbalanced;
    }
}