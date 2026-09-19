class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int dist = 0;
        
        // int closestX = Math.abs(x1-xCenter)<Math.abs(x2-xCenter)?x1:x2;
        // int closestY = Math.abs(y1-yCenter)<Math.abs(y2-yCenter)?y1:y2;
        int closestX = Math.max(x1, Math.min(x2,xCenter));
        int closestY = Math.max(y1, Math.min(y2,yCenter));
        return (closestX-xCenter)*(closestX-xCenter) + (closestY-yCenter)*(closestY-yCenter)<=radius*radius;
    }
}

/*
Closest x and closest y..


*/