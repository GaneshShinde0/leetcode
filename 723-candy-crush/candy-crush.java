class Solution {
    record Pair(int key, int value){}
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        while(true){
            HashSet<Pair> clear = new HashSet<>();
            for(int i=0;i<m;i++){
                int streak = 0, last = -1;
                for(int j=0;j<n;j++){
                    // if(board[i][j]==0){
                    //     last =-1;
                    //     continue;
                    // }
                    if(board[i][j]==last) streak+=1;
                    else{
                        last = board[i][j];
                        streak = 1;
                    }
                    if (streak == 3 && last>0) {
                        clear.add(new Pair(i, j));
                        clear.add(new Pair(i, j - 1)); // Add the 2nd candy
                        clear.add(new Pair(i, j - 2)); // Add the 1st candy
                    } else if (streak > 3  && last>0) {
                        clear.add(new Pair(i, j)); // 1st and 2nd are already in the set
                    }
                }
            }
            for(int j=0;j<n;j++){
                int streak = 0, last = -1;
                for(int i=0;i<m;i++){
                    // if(board[i][j]==0){
                    //     last =-1;
                    //     continue;
                    // }
                    if(board[i][j]==last) streak+=1;
                    else{
                        last = board[i][j];
                        streak = 1;
                    }
                    if (streak == 3 && last>0) {
                        clear.add(new Pair(i, j));
                        clear.add(new Pair(i - 1, j)); // Add the 2nd candy
                        clear.add(new Pair(i - 2, j)); // Add the 1st candy
                    } else if (streak > 3  && last>0 ) {
                        clear.add(new Pair(i, j)); // 1st and 2nd are already in the set
                    }
                }
            }
            if(clear.size()==0) return board;
            for(Pair p:clear){
                board[p.key()][p.value()]=0;
            }
            // We can use two pointers to drop.
            for(int j=0;j<n;j++){
                int ptr = m-1;
                for(int i=m-1;i>=0;i--){
                    if(board[i][j]!=0){
                        board[ptr][j]=board[i][j];
                        ptr--;
                    }
                }
                while(ptr>=0){
                    board[ptr][j]=0;
                    ptr--;
                }

            }
        }
    }
}