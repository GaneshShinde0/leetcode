class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int count = 0, maxCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        maze[start[0]][start[1]] = -1;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0]==destination[0]&&curr[1]==destination[1]) return true;
            for(int[] dir:dirs){
                int newI = curr[0]+dir[0];
                int newJ = curr[1]+dir[1];
                if(newI<0||newJ<0||newI>=m||newJ>=n) continue;
                while(newI>=0 && newJ>=0 && newI<m && newJ<n && maze[newI][newJ]!=1){
                    newI+=dir[0];
                    newJ+=dir[1];
                }
                if(maze[newI-dir[0]][newJ-dir[1]]!=-1){
                    queue.add(new int[]{newI-dir[0],newJ-dir[1]});
                    maze[newI-dir[0]][newJ-dir[1]]=-1;
                }
            }
        }
        return false;
    }
}