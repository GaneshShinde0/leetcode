
/*
Input: bottomLeft = [[1,1],[2,2],[3,1]], topRight = [[3,3],[4,4],[6,6]]
Add bottomLeft to TreeSet
*/
class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxSide = 0;
        int n = bottomLeft.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int w = Math.min(topRight[i][0],topRight[j][0])-Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                int h = Math.min(topRight[i][1],topRight[j][1])-Math.max(bottomLeft[i][1],bottomLeft[j][1]);

                int side = Math.min(w,h);
                maxSide = Math.max(maxSide, side);
            }
        }
        return maxSide*maxSide;
    }
}