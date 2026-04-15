/*
Every two points can meet in their middle, When Third Point is added that changes.
*/

class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> xPos = new ArrayList<>();
        List<Integer> yPos = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) yPos.add(i);
            }
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                if(grid[i][j]==1) xPos.add(j);
            }
        }

        int xMedian = xPos.get(xPos.size()/2);
        int yMedian = yPos.get(yPos.size()/2);

        int result = 0;
        for(int i:xPos) result +=Math.abs(i-xMedian);        
        for(int i:yPos) result +=Math.abs(i-yMedian); 
        return result;       
    }
}