class State{
    int row, col, dist;
    String path;
    public State(int row, int col, int dist, String path){
        this.row = row;
        this.col = col;
        this.dist = dist;
        this.path = path;
    }
}
class Solution {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    String[] textDirections = new String[]{"d","r","l","u"};
    int m, n;
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        this.m = maze.length;
        this.n = maze[0].length;
        PriorityQueue<State> pq = new PriorityQueue<>((a,b)->{
            if(a.dist==b.dist) return a.path.compareTo(b.path);
            else return Integer.compare(a.dist,b.dist);
        });
        boolean[][] seen = new boolean[m][n];
        pq.add(new State(ball[0],ball[1],0,""));

        while(!pq.isEmpty()){
            State curr = pq.poll();
            int row = curr.row;
            int col = curr.col;
            if(seen[row][col]) continue;
            if(row==hole[0] && col == hole[1]) return curr.path;
            seen[row][col] = true;
            for(State next:getNeighbors(row,col, maze,hole)){
                int newRow = next.row;
                int newCol = next.col;
                int newDist = next.dist;
                String newDir = next.path;
                pq.add(new State(newRow, newCol, curr.dist+newDist, curr.path+newDir));
            }
        }
        return "impossible";
    }
    private boolean isValid(int r, int c, int[][] maze){
        if(r<0||r>=m||c<0||c>=n) return false;
        return maze[r][c]==0;
    }
    private List<State> getNeighbors(int row, int col, int[][] maze, int[] hole){
        List<State> neighbors = new ArrayList<>();
        for(int i=0;i<4;i++){
            int dx = dirs[i][0];
            int dy = dirs[i][1];
            String direction = textDirections[i];
            int currRow = row;
            int currCol = col;
            int dist = 0;
            while(isValid(currRow+dy,currCol+dx, maze)){
                currRow+=dy;
                currCol+=dx;
                dist++;
                if(currRow==hole[0]&& currCol==hole[1]) break;
            }
            neighbors.add(new State(currRow, currCol, dist, direction));
        }
        return neighbors;
    }
}