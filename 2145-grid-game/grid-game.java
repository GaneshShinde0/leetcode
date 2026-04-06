class Solution {
    public long gridGame(int[][] grid) {
        long firstRowSum = 0;
        for(int num:grid[0]) firstRowSum+=num;
        long secondRowSum = 0;
        long result = Long.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            firstRowSum -= grid[0][i];
            result = Math.min(result,Math.max(firstRowSum,secondRowSum));
            secondRowSum += grid[1][i];
        }
        return result;
    }
}