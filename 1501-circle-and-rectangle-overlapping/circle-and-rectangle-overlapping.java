class Solution {

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double dist = 0;
        if(xCenter<x1 || xCenter>x2){
            dist += Math.min(Math.pow(x1-xCenter,2), Math.pow(x2-xCenter,2));
        }
        if(yCenter<y1 || yCenter>y2){
            dist += Math.min(Math.pow(y1-yCenter,2), Math.pow(y2-yCenter,2));
        }
        return dist<=radius*radius;
    }

    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public boolean checkOverlapDoesNotWork(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        boolean touches = false;
        // Four Corner Distance With Center
        touches|=dist(xCenter, yCenter, x1,y1)<=radius;
        touches|=dist(xCenter, yCenter, x1,y2)<=radius;
        touches|=dist(xCenter, yCenter, x2,y1)<=radius;
        touches|=dist(xCenter, yCenter, x2,y2)<=radius;
        touches|=xCenter>=x1 &&xCenter<=x2 && yCenter>=y1 && yCenter<=y2;
        for(int[] dir:dirs){
            int newX = xCenter+dir[0]*radius, newY = yCenter+dir[1]*radius;
            touches|= newX>=x1 &&newX<=x2 && newY>=y1 && newY<=y2;
            if(touches) return true;
        }
        return false;
    }
    
    private double dist(int x1, int y1, int x2, int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
}