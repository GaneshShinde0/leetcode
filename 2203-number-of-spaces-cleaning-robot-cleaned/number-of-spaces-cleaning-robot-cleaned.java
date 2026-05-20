class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numberOfCleanRooms(int[][] room) {
        int m = room.length, n = room[0].length, res = 0;
        boolean[][][] vis = new boolean[m][n][4];
        int d = 0, i=0,j=0;
        while(!vis[i][j][d%4]){
            vis[i][j][d%4]=true;
            if (room[i][j] == 0) { // Using the room array itself to track!
                res++;
                room[i][j] = 2; // Mark it as cleaned so we never count it again
            }
            int[] dir=dirs[d%4];
            int newI = i+dir[0];
            int newJ = j+dir[1];
            if(newI<m && newI>=0 && newJ>=0 && newJ<n && room[newI][newJ]!=1){
                i=newI;
                j=newJ;
            }else{
                d++;
            }
        }
        return res;
    }
}