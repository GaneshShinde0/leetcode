/*
Distance between tree to all nuts will be twice.
- Except for one nut .... distance between squirell to nut will be considered. and tree to nut.

*/
class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int totalDistance = 0, d=Integer.MIN_VALUE;
        for(int[] nut:nuts){
            int curr = getDistance(tree,nut);
            totalDistance+=2*curr;
            d = Math.max(d,curr-getDistance(squirrel,nut)); // Maximize distance that can be reduced.
        }
        return totalDistance-d;
    }
    private int getDistance(int[] p1,int[] p2){
        return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
    }
}