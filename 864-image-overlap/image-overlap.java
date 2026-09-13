class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int m = img1.length, n = img1[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res = Math.max(res, shiftCheck(i,j,img1,img2));
                res = Math.max(res, shiftCheck(i,j,img2,img1));
            }
        }
        return res;
    }
    private int shiftCheck(int x, int y, int[][] img1, int[][] img2){
        int m = img1.length, n = img1[0].length;
        int leftShiftCount = 0, rightShiftCount=0;
        int rowShift = 0;
        for(int i=x;i<m;i++){
            int colShift = 0;
            for(int j=y;j<n;j++){
                if(img1[i][j]==1 && img1[i][j]==img2[i-x][j-y]) leftShiftCount++;
                if(img1[i][colShift]==1 && img1[i][colShift]==img2[i-x][j]) rightShiftCount++;
                colShift++;
            }
            rowShift++;
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }
}