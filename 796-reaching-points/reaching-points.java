/*
# Basic Idea
- If we start from sx, sy, it will be hard to find tx , ty.
- If we start from tx, ty, we can find only one parth to go back to sx, xy.

First Line
- If 2 target points are still bigger than 2 starting points, we reduce target points.

Second Line
- Check if we reduce target points to (x,y+kx) or (x+ky, y)

Complexity:
Space : O(1)
Time  : O(log(min(tx,ty))).


*/

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(sx<tx && sy<ty){
            if(tx<ty) ty %=tx;
            else tx%=ty;
        }

        return sx == tx && sy<=ty && (ty-sy)%sx == 0 ||
                sy==ty && sx<=tx && (tx-sx)%sy==0;
    }
}