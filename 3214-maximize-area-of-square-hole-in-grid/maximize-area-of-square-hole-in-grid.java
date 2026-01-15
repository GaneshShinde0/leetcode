class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxRows =1, maxCols = 1;
        int countHBars = 1, countVBars = 1;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]==hBars[i-1]+1) countHBars++;
            else countHBars = 1;
            maxRows = Math.max(maxRows, countHBars);
        }        
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]==vBars[i-1]+1) countVBars++;
            else countVBars = 1;
            maxCols = Math.max(maxCols,countVBars);
        }
        int side = Math.min(maxCols+1,maxRows+1);
        return side*side;
    }
}