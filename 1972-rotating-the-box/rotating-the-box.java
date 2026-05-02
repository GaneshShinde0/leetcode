class Solution {
    public char[][] rotateTheBox(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        char[][] res = new char[cols][rows];
        for(char[] row:res) Arrays.fill(row,'.');

        for(int i=0;i<rows;i++){
            int chooseRow = cols-1; // Only row will get changed
            int chooseCol = rows-i-1; // Wont change.
            for(int j=cols-1;j>=0;j--){
                if(grid[i][j]=='#'){
                    res[chooseRow][chooseCol]='#';
                    chooseRow--;
                }else if(grid[i][j]=='*'){
                    res[j][chooseCol]='*';
                    chooseRow = j-1;
                }
            }
        }
        return res;
    }
}