/*
Approach 1: DFS
- We can view the given search space in the form of a tree. The root node of the tree represents the starting position. For different routes are possible from each position i.e., left, right, up, down. These four routes are possible from each position . These 4 can be represented by 4 branches of each node in the given tree. Thus, the new node reached from the root traversing over the branch represents new position occupied by the ball after choosing the corresponding direction of travel.

*/
class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int shortestDistance(int[][] maze, int[] start, int[] des) {
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] row:distance) Arrays.fill(row,Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dfs(maze,start,distance);
        return distance[des[0]][des[1]]==Integer.MAX_VALUE? -1:distance[des[0]][des[1]];
    }
    public void dfs(int[][] maze, int[] start, int[][] distance){
        for(int[] dir:dirs){
            int x = start[0]+dir[0];
            int y = start[1]+dir[1];
            int count = 0;
            while(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y]==0){
                x+=dir[0];
                y+=dir[1];
                count++;
            }
            if(distance[start[0]][start[1]]+count<distance[x-dir[0]][y-dir[1]]){
                distance[x-dir[0]][y-dir[1]] = distance[start[0]][start[1]]+count;
                dfs(maze,new int[]{x-dir[0],y-dir[1]},distance);
            }
        }
    }
}