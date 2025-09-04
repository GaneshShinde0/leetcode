class Solution {
    public int findClosest(int x, int y, int z) {
        int x1 = Math.abs(z-x);
        int y1 = Math.abs(z-y);
        if(x1>y1) return 2;
        else if(x1 < y1) return 1;
        else return 0;
    }
}