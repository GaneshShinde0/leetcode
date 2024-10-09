class CountNegativesFromSortedArray {
    public int countNegatives(int[][] grid) {
        int count=0;
        int m= grid.length;
        int n = grid[0].length;
        int j=0;
        for(int i=0;i<m;i++){
            while((n-j)>0 && grid[i][n-j-1]<0 ){
                j++;
            }
            count+=j;
        }
        return count;
    }
}
