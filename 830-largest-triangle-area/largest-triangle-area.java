class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        int n = points.length;

        for(int i =0; i<n; i++)
            for(int j =i+1; j<n; j++)
                for(int k =j+1; k<n; k++)
                    ans = Math.max(ans , Math.abs(area(points[i], points[j], points[k])));
        return ans;
    }
    public static double area(int[] x1, int[] x2, int[] x3)
    {
        int t1 = x1[0] * ( x2[1] - x3[1]);
        int t2 = x2[0] * ( x3[1] - x1[1]);
        int t3 = x3[0] * ( x1[1] - x2[1]);
        return (double)( t1 + t2 + t3 )/2;
    }
}