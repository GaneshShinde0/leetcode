class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n =  grid[0].length, result = 0;
        int[][] freqX = new int[m+1][n+1];
        int[][] freqY = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                freqX[i+1][j+1] = freqX[i][j+1]+freqX[i+1][j]-freqX[i][j];
                freqY[i+1][j+1] = freqY[i][j+1]+freqY[i+1][j]-freqY[i][j];
                if(grid[i][j]=='X'){
                    freqX[i+1][j+1]+=1;
                }else if(grid[i][j]=='Y'){
                    freqY[i+1][j+1]+=1;
                }
                if(freqX[i+1][j+1]>0 && freqX[i+1][j+1]==freqY[i+1][j+1]) result++;
            }
        }
        return result;
    }
}

/*
Input: grid = [["X","Y","."],["Y",".","."]]

[
    [0,0,0,0]
    [0,1,1,1]
    [0,1,0,0]
]
[
    [0,0,0,0]
    [0,0,1,1]
    [0,1,0,0]
]
resilt++;
result = 1;

*/