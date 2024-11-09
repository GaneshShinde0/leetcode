class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res =0;
        for(int i=1;i<points.length;i++){
            // res+=(int) Math.ceil(Math.sqrt((points[i-1][0]-points[i][0])*(points[i-1][0]-points[i][0])+(points[i-1][1]-points[i][1])*(points[i-1][1]-points[i][1])));
            res+=Math.max(Math.abs(points[i-1][0]-points[i][0]),Math.abs(points[i-1][1]-points[i][1]));
        }
        return res;
    }

    int seconds(int[] p1, int[] p2) {
        int x = Math.abs(p1[0] - p2[0]);
        int y = Math.abs(p1[1] - p2[1]);
        int max = Math.min(x, y);
        if (max == x && max == y) {
            return max;
        }
        if (x > max) {
            return max + (x - max);
        }
        return max + (y - max);
    }

    public int minTimeToVisitAllPointsAlternate(int[][] points) {
        int ans = 0;
        int n = points.length;
        for (int i = 0; i < n - 1; i++)
            ans += seconds(points[i], points[i + 1]);
        return ans;
    }
}
