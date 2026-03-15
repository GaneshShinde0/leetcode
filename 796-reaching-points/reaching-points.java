import java.awt.Point;
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
    public boolean reachingPointsFinal(int sx, int sy, int tx, int ty) {
        while(sx<tx && sy<ty){
            if(tx<ty) ty %=tx;
            else tx%=ty;
        }

        return sx == tx && sy<=ty && (ty-sy)%sx == 0 ||
                sy==ty && sx<=tx && (tx-sx)%sy==0;
    }

    /*
    Other Approaches:
    Approach 1: Exhaustive Search: TLE
    */
    public boolean reachingPoints103of197(int sx, int sy, int tx, int ty){
        if(sx>tx || sy>ty) return false;
        if(sx==tx && sy == ty) return true;
        return reachingPoints(sx+sy,sy,tx,ty) || reachingPoints(sx, sx+sy, tx,ty);
    }

    /* Approach 2: DP [TLE]
    We search the children of every point recursively, except we use a set seen so that we dont repeat work.
    Time Complexity: O(tx∗ty), as at most tx * ty points are searched once per point.

    Space Complexity: O(tx∗ty), the size of the implicit call stack.
    */
    Set<Point> seen;
    int tx, ty;

    public boolean reachingPoints103of197StackOverflow(int sx, int sy, int tx, int ty){
        seen = new HashSet<>();
        this.tx = tx;
        this.ty = ty;
        search(new Point(sx, sy));
        return seen.contains(new Point(tx, ty));
    }

    public void search(Point p){
        if(seen.contains(p)) return;
        if(p.x>tx || p.y>ty) return;
        seen.add(p);
        search(new Point(p.x+p.y,p.y));
        search(new Point(p.x, p.x+p.y));
    }

    /*
    Approach 3: Work Backwards (Naive Variant) TLE

    Every parent point (x,y) has two children (x,x+y) and (x+y, y). However, every point (x,y) has only one parent candidate(x-y, y) if(x>=y), else (x,y-x).
    This is because we never have points with negative co-ordinates.

    Looking at previous successive parents of the target point, we can find whethere the starting point was an ancestor. For example, if the target point is (19,12), the successive parents must have been (7,12), (7,5) and (2,5) so; (2,5) is starting point of 19,12

    Algorithm:

    Repeatedly subtract the smaller of (tx,ty) from the larget of (tx,ty) the answer is true if and only if we eventually reach sx, sy.


    Complexity:

    Time : O(Max(tx, ty)), If say ty = 1, we could be subtracting tx times.
    Space: O(1)
    */

    public boolean reachingPointsTLE193of197(int sx, int sy, int tx, int ty){
        while(tx>=sx && ty>= sy){
            if(sx==tx && sy==ty) return true;
            if(tx>ty) tx -= ty;
            else ty -= tx;
        }
        return false;
    }

    /*
    Approach 4: Work Backwards (Modulo Variant)
    Similar to approach 3, we work backwards to find the answer, trying to transform the target points to the starting point via applying the parent operation (x, y)-> (x-y, y) or (x,y-x) [Depending on which one doesn;t have negative co-ordinates].

    We can speed up this transformation by bundling together parent operations.
    
    Algorithm:
    Say tx>ty. We know that the next parent operations will be to subtract ty from tx, until such time that tx = tx%ty. When both tx>ty and ty>sy, we can perform all these parent operations in one step, replacing while tx>ty:tx-=ty with tx%ty;

    Otherwise, if say tx>ty and ty<=sy then we know ty will not be changing(it can only decrease).. Thus only tx will change, and it can only change by subtracting by ty. Hence (tx-sx)% ty ==0  is a necessary and sufficient condition for the problem's answer to be True.

    The analysis above was for the case tx>ty, but the case ty>tx is similar. When tx==ty, no more moves can be made.
    */

    public boolean reachingPoints(int sx, int sy, int tx, int ty){
        while(tx>=sx && ty>=sy){
            if(tx==ty) break;
            if(tx>ty){
                if(ty>sy) tx%=ty;
                else return (tx-sx)%ty==0;
            }else{
                if(tx>sx) ty %= tx;
                else return (ty-sy)%tx==0;
            }
        }
        return (tx==sx && ty==sy);
    }
}


/*
Other Approaches:

Approach 1: Exhaustive Search: TLE

public boolean reachingPoint(int sx, int sy, int tx, int ty){
    if(sx>)
}
*/