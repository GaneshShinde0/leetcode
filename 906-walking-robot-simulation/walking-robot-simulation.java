class Solution {
    int[][] dirs = new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Integer> obstacleSet = new HashSet<>();
        for(int[] o:obstacles) obstacleSet.add(60000*o[0]+600000000+o[1]+60000);
        int x = 0, y= 0;
        int d = 3;
        boolean isStart = true;
        int res = 0;
        for(int com:commands){
            if(com == -1) d=(d+1)%4;
            else if(com==-2) d = (4+d-1)%4;
            else{
                int xPlus = dirs[d][0], yPlus = dirs[d][1];
                while(com>0){
                    if(obstacleSet.contains((x+xPlus)*60000+600000000+(y+yPlus)+60000)) break;
                    x+=xPlus;
                    y+=yPlus;
                    com--;
                    res = Math.max(res, x*x+y*y);
                    isStart = false;
                }
            }
        }
        return res;
    }
}