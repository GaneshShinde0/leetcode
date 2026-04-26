/*
[
    ["f","a","a","c","b"],
    ["e","a","a","e","c"],
    ["c","f","b","b","b"],
    ["c","e","a","b","e"],
    ["f","e","f","b","f"]]
*/

class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Stack<int[]> stk = new Stack<>();
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                if(Character.isUpperCase(grid[x][y])) continue;
                stk.add(new int[]{(int)grid[x][y],x,y,-1,-1});
                while(!stk.isEmpty()){
                    int[] curr = stk.pop();
                    int i = curr[1];
                    int j = curr[2];
                    for(int[] dir:dirs){
                        int newI = i+dir[0];
                        int newJ = j+dir[1];
                        if(newI>=m || newJ>=n || newI<0 || newJ<0 || (newI==curr[3] && newJ==curr[4])){
                            continue; 
                        }
                        if(grid[newI][newJ]==(curr[0]-28)){
                            return true;
                        }
                        if(grid[newI][newJ]==curr[0]){
                            stk.add(new int[]{(int)grid[newI][newJ], newI, newJ,i,j});
                        }
                    }
                    grid[i][j]-=28;
                }
            }
        }
        return false;
    }
}