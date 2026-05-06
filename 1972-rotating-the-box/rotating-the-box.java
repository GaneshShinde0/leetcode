class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] res = new char[n][m];
        for(char[] arr:res) Arrays.fill(arr, '.');
        for(int i=0;i<m;i++){
            int chooseRow = n-1;
            int chooseCol = m-i-1;
            for(int j=n-1;j>=0;j--){// Row;
                if(boxGrid[i][j]=='#'){
                    res[chooseRow][chooseCol]='#';
                    chooseRow--;
                }else if(boxGrid[i][j]=='*'){
                    res[j][chooseCol] = '*';
                    chooseRow=j-1;
                }
            }
        }
        return res;
    }
}