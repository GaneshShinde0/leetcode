class Solution {
    public int maxCountMemoryLimitExceeded(int m, int n, int[][] ops) {
        int[][] arr = new int[m][n];
        int max =0;
        for(int[] temp:ops){
            for(int i=0;i<temp[0];i++){
                for(int j=0;j<temp[1];j++){
                    arr[i][j]++;
                    max = Math.max(arr[i][j],max);
                }
            }
        }
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==max) count++;
            }
        }
        return count;
    }

    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;
        
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        
        return minRow * minCol;
    }
}
