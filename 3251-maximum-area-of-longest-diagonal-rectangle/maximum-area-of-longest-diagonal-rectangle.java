class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        double[][] area = new double[n][2];
        double maxDig = 0;
        double maxArea = 0;
        for(int i=0;i<n;i++){
            area[i][0]=dimensions[i][0]*dimensions[i][1];
            area[i][1]=dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1];
            if(area[i][1]>maxDig){
                maxDig = area[i][1];
                maxArea = area[i][0];
            }else if (area[i][1]==maxDig && area[i][0]>maxArea){
                maxArea = area[i][0];
            }
        }
        return (int) maxArea;
    }
}