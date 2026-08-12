class Solution {
    int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
    public boolean isRobotBoundedInitial(String instructions) {
        int x = 0, y = 0, dirPtr=0;
        for(char c:instructions.toCharArray()){
            if(c=='G'){
                x+=dirs[dirPtr][0];
                y+=dirs[dirPtr][1];
            }else if(c=='L'){
                dirPtr = (dirPtr+4-1)%4;
            }else if(c=='R'){
                dirPtr = (dirPtr+1)%4;
            }
        }
        if((x==0 && y==0) || dirPtr%4!=0) return true;
        else return false;
    }
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dirPtr=0;
        for(char c:instructions.toCharArray()){
            if(c=='G'){
                x+=dirs[dirPtr][0];
                y+=dirs[dirPtr][1];
            }else if(c=='L'){
                dirPtr = (dirPtr+4-1)%4;
            }else if(c=='R'){
                dirPtr = (dirPtr+1)%4;
            }
        }
        return ((x==0 && y==0) || dirPtr!=0); // If it reached origin or going in one direction?
    }
}

/*
   ||
   ||
*/