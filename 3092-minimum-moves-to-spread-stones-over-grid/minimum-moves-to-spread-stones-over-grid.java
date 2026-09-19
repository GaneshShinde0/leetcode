class Solution {
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