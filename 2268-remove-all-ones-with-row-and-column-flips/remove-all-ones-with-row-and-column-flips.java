class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] first = grid[0];
        for(int i=1;i<m;i++){
            boolean areSame = first[0]==grid[i][0];
            for(int j=1;j<n;j++){
                if(areSame ^ first[j]==grid[i][j]) return false;
            }
        }
        return true;
    }
}