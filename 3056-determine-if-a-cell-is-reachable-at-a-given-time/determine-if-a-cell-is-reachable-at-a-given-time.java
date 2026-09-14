class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int chebyshevDist = Math.max(Math.abs(sy-fy),Math.abs(sx-fx));
        // System.out.println(chebyshevDist);
        if( (sx==fx && sy==fy && t==1)) return false;
        return (chebyshevDist<=t);
    }
}

/*

1111
11e1
1s11
1111
*/