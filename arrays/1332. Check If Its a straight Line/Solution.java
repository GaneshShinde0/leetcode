class Solution {
    public boolean checkStraightLineInitialSolution(int[][] coordinates) {
        int n = coordinates.length;
        double slope = getSlope(coordinates[0],coordinates[1]);
        for(int i=2;i<n;i++){
            double tempSlope = getSlope(coordinates[i-1],coordinates[i]);
            if(tempSlope!=slope) return false;
        }

        return getSlope(coordinates[0],coordinates[n-1])==slope?true:false;
    }
    public double getSlope(int[] a, int[] b){
        if(a[0]==b[0]) return Double.MAX_VALUE;
        return (a[1]-b[1])/(a[0]-b[0]);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;

        // Get the difference of the first two points
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];

        // Loop through the remaining points and check the slope ratio
        for (int i = 2; i < n; i++) {
            int dx1 = coordinates[i][0] - coordinates[i - 1][0];
            int dy1 = coordinates[i][1] - coordinates[i - 1][1];

            // Instead of comparing the slopes directly, we compare cross-multiplication
            // dy/dx == dy1/dx1 <=> dy * dx1 == dy1 * dx
            if (dy * dx1 != dy1 * dx) {
                return false;
            }
        }

        return true;
    }
}
