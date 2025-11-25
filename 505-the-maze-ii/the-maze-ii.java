/*
Approach 1: DFS
- We can view the given search space in the form of a tree. The root node of the tree represents the starting position. For different routes are possible from each position i.e., left, right, up, down. These four routes are possible from each position . These 4 can be represented by 4 branches of each node in the given tree. Thus, the new node reached from the root traversing over the branch represents new position occupied by the ball after choosing the corresponding direction of travel.

*/
class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    // Takes 250 ms
    public int shortestDistanceDFS(int[][] maze, int[] start, int[] des) {
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

    // Takes 9 ms
    public int shortestDistanceBFS(int[][] maze, int[] start, int[] dest){
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] row:distance) Arrays.fill(row,Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int[] s = queue.poll();
            for(int[] dir:dirs){
                int x = s[0]+dir[0];
                int y = s[1]+dir[1];
                int count = 0;
                while(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y]==0){
                    x+=dir[0];
                    y+=dir[1];
                    count++;
                }
                if((distance[s[0]][s[1]]+count)<distance[x-dir[0]][y-dir[1]]){
                    distance[x-dir[0]][y-dir[1]] = distance[s[0]][s[1]]+count;
                    queue.add(new int[]{x-dir[0],y-dir[1]});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE?-1:distance[dest[0]][dest[1]];
    }

    public int shortestDistanceDijkstra(int[][] maze, int[] start, int[] dest){
        int[][] distance = new int[maze.length][maze[0].length];
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        for(int[] row:distance) Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, distance, visited);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1:distance[dest[0]][dest[1]];
    }

    public int[] minDistance(int[][] distance, boolean[][] visited){
        int[] min = {-1,-1};
        int min_val = Integer.MAX_VALUE;
        for(int i=0;i<distance.length;i++){
            for(int j=0;j<distance[0].length;j++){
                if(!visited[i][j] && distance[i][j]<min_val){
                    min = new int[] {i,j};
                    min_val = distance[i][j];
                }
            }
        }
        return min;
    }

    public void dijkstra(int[][] maze, int[][] distance, boolean[][] visited){
        while(true){
            int[] s = minDistance(distance, visited);
            if(s[0]<0) break;
            visited[s[0]][s[1]] = true;
            for(int[] dir:dirs){
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while(x>=0 && y>=0 && x<maze.length && y <maze[0].length && maze[x][y]==0){
                    x+=dir[0];
                    y+=dir[1];
                    count++;
                }
                if(distance[s[0]][s[1]]+count<distance[x-dir[0]][y-dir[1]]){
                    distance[x-dir[0]][y-dir[1]] = distance[s[0]][s[1]]+count;
                }
            }
        }
    }
    // Dijkstra with PQ.
    public int shortestDistance(int[][] maze, int[] start, int[] dest){
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] row:distance) Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1:distance[dest[0]][dest[1]];
    }

    public void dijkstra(int[][] maze, int[] start, int[][] distance){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
        queue.offer(new int[]{start[0],start[1],0});
        while(!queue.isEmpty()){
            int[] s = queue.poll();
            if(distance[s[0]][s[1]]<s[2]) continue;
            for(int[] dir:dirs){
                int x = s[0]+dir[0];
                int y = s[1]+dir[1];
                int count = 0;
                while(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y]==0){
                    x+=dir[0];
                    y+=dir[1];
                    count++;
                }
                if(distance[s[0]][s[1]]+count<distance[x-dir[0]][y-dir[1]]){
                    distance[x-dir[0]][y-dir[1]] = distance[s[0]][s[1]]+count;
                    queue.offer(new int[]{x-dir[0],y-dir[1], distance[x-dir[0]][y-dir[1]]});
                }
            }
        }
    }
    
}