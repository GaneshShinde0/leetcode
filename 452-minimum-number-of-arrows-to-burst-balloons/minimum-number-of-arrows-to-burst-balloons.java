class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int res = 1, end = points[0][1];
        for(int[] point:points){
            if(point[0]<=end) continue;
            else{
                end = point[1];
                res++;
            }
        }
        return res;
    }
}