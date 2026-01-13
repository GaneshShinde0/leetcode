class Solution {
    public double separateSquares(int[][] squares) {
        double low = Integer.MAX_VALUE, high = 0,totalArea = 0;
        for(int[] s:squares){
            low = Math.min(s[1],low);
            high = Math.max(s[1]+s[2],high);
            totalArea += (double)s[2]*s[2];
        }
        while(Math.abs(high-low)>1e-5){
            double mid = low + (high-low)/2;
            if(check(mid, squares, totalArea)){
                high = mid;
            }else{
                low = mid;
            }
        }
        return low;
    }

    private boolean check(double mid, int[][] squares, double totalArea){
        double area = 0;
        // Now calculating the below area;`
        for(int[] s:squares){
            double y = s[1];
            double diagonal= s[2];
            if(y<mid){
                area += (double) diagonal*Math.min(mid-y,diagonal);
            }
        }
        return area>=totalArea/2;
    }
}