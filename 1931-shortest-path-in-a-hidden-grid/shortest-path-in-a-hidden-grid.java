class Solution {
    
    private static final int BLOCKED = -1;
    private static final int UNEXPLORED = 0;
    private static final int PATH = 1;
    private static final int TARGET = 2;
    private static final int START = 3;
        
    public int findShortestPath(GridMaster master) {
        int m = 501;
        int[][] board = new int[m*2][m*2];
        int[] start = new int[] {m, m};
        board[m][m] = START;
        int[] target = findTarget(master, board, m, m);
        return target == null ? -1 : getDistance(board, target, start);
    }
    
	// dfs
    private int[] findTarget(GridMaster master, int[][] board, int r, int c) {
        if (master.isTarget()) {
            board[r][c] = TARGET;
            return new int[]{r,c};
        }
            
        int[] res = null;
        for (Direction d : Direction.values()) {
            int r2 = r + d.n[0];
            int c2 = c + d.n[1];
            if (board[r2][c2] == UNEXPLORED) {
                if (master.canMove(d.c)) {
                    master.move(d.c);
                    board[r2][c2] = PATH;
                    int[] target = findTarget(master, board, r2, c2);
                    if (target != null)
                        res = target;
                    master.move(d.o);
                } else {
                    board[r2][c2] = BLOCKED;
                }
            }
        }
        return res;
    }
    
	// bfs
    private int getDistance(int[][] board, int[] target, int[] start) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(target);
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();    
                for (Direction d : Direction.values()) {
                    int r2 = cur[0] + d.n[0];
                    int c2 = cur[1] + d.n[1];
                    if (board[r2][c2] == START)
                        return distance;
                    else if (board[r2][c2] == PATH) {
                        board[r2][c2] = BLOCKED;
                        queue.add(new int[]{r2,c2});
                    }
                }
            }
            distance++;            
        }
        
        return distance;
    }    
    
    enum Direction {
        UP('U', 'D', new int[]{0,1}),
        DOWN('D', 'U', new int[]{0,-1}),
        LEFT('L', 'R', new int[]{-1,0}),
        RIGHT('R', 'L', new int[]{1,0});
        
        public char c;
        public char o;
        public int[] n;
        
        Direction(char c, char o, int[] n) {
            this.c = c;
            this.o = o;
            this.n = n;
        }            
    }
}