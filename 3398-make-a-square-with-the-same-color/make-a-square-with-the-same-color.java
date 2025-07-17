class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                int b=0,w=0;
                if(grid[i][j]=='B')b+=1;
                if(grid[i][j+1]=='B')b+=1;
                if(grid[i+1][j]=='B')b+=1;
                if(grid[i+1][j+1]=='B')b+=1;
                if(b!=2) return true;
            }
        }
        return false;
    }
}