class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        long res = 0, prev = Long.MIN_VALUE;
        int n = points.length; 
        for(int i=0;i<n;i++){
            if(points[i][0]>prev){
                res++;
                prev = points[i][1];
            }
        }
        return (int) res;
    }
}