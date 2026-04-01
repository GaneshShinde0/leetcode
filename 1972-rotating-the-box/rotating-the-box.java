class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n= boxGrid[0].length;
        char[][] res = new char[n][m];
        for(int i=0;i<m;i++){
            int right=n-1;
            for(int left = n-1; left>=0; left--){
                if(boxGrid[i][left]=='*'){
                    res[left][m-i-1]='*';
                    right=left-1;
                }else if(boxGrid[i][left]=='#'){
                    res[right][m-i-1]='#';
                    right--;
                }
            }
            for(int j=0;j<n;j++){
                if(res[j][i]=='\u0000') res[j][i]='.';
            }
        }
        return res;
    }
}