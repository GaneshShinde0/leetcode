class Solution {
    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Stack<int[]> stack = new Stack<>();
        Set<Integer> onRight = Set.of(1,3,5);
        Set<Integer> onLeft = Set.of(1,4,6);
        Set<Integer> onUp = Set.of(2,3,4);
        Set<Integer> onDown = Set.of(2,5,6);
        stack.add(new int[]{0,0});
        while(!stack.isEmpty()){
            int[] curr = stack.pop();
            int i = curr[0];
            int j = curr[1];
            if(i==m-1 && j==n-1) return true;
            int prevPath = grid[i][j];
            for(int[] dir:dirs){
                int newI = i+dir[0];
                int newJ = j+dir[1];
                if(newI<0||newJ<0||newI>=m||newJ>=n||grid[newI][newJ]==0) continue;
                if((prevPath==1 && newJ==j+1 && onRight.contains(grid[newI][newJ]))||
                    (prevPath==1 && newJ==j-1 && onLeft.contains(grid[newI][newJ]))||
                    (prevPath==2 && newI==i-1 && onUp.contains(grid[newI][newJ]))||
                    (prevPath==2 && newI==i+1 && onDown.contains(grid[newI][newJ]))||
                    (prevPath==3 && newI==i+1 && onDown.contains(grid[newI][newJ]))||
                    (prevPath==3 && newJ==j-1 && onLeft.contains(grid[newI][newJ]))||
                    (prevPath==4 && newI==i+1 && onDown.contains(grid[newI][newJ]))||
                    (prevPath==4 && newJ==j+1 && onRight.contains(grid[newI][newJ]))||
                    (prevPath==5 && newI==i-1 && onUp.contains(grid[newI][newJ]))||
                    (prevPath==5 && newJ==j-1 && onLeft.contains(grid[newI][newJ]))||
                    (prevPath==6 && newI==i-1 && onUp.contains(grid[newI][newJ]))||
                    (prevPath==6 && newJ==j+1 && onRight.contains(grid[newI][newJ]))){
                    stack.push(new int[]{newI, newJ});
                }
            }
            grid[i][j]=0;

        }
        return false;
    }
}