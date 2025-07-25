class Solution {
    public int numRookCaptures(char[][] board) {
        int m = board.length, n = board[0].length;
        int i=0;
        int j=0;
        boolean flag = false;
        for(;i<m;i++){
            for(j=0;j<n;j++){
                // System.out.println(board[i][j]);
                if(board[i][j]=='R'){
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        System.out.println("i: "+i+",j: "+j);
        int res = 0;
        for(int x=i-1;x>=0;x--){
            if(board[x][j]=='.') continue;
            else if(board[x][j]=='p') {
                res++;
                break;
            }
            else break;
        }
        for(int x=i+1;x<8;x++){
            if(board[x][j]=='.') continue;
            else if(board[x][j]=='p') {
                res++;
                break;
            }
            else break;
        }
        for(int x=j-1;x>=0;x--){
            if(board[i][x]=='.') continue;
            else if(board[i][x]=='p') {
                res++;
                break;
            }
            else break;
        }
        for(int x=j+1;x<8;x++){
            if(board[i][x]=='.') continue;
            else if(board[i][x]=='p'){
                res++;
                break;
            }
            else break;
        }
        return res;
    }
}