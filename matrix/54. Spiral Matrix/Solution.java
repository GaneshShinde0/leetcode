class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i=0,j=0,currentDirection=0;
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        int[] res = new int[matrix.length*matrix[0].length];
        int[][] directions = {
            {0,1},  // Column is incrementing 
            {1,0},  // Row is incrementing 
            {0,-1}, // Column is decrementing 
            {-1,0}  // Row is decrementing 
        };
        int t=0;
        for(int z= 0;z<res.length;z++){
            res[z] = matrix[i][j];
            isVisited[i][j] = true;

            int newi = i+directions[currentDirection][0];
            int newj = j+directions[currentDirection][1];

            if(
                Math.min(newi,newj)<0 ||
                newi >= matrix.length ||
                newj >= matrix[0].length || 
                isVisited[newi][newj]
            ) currentDirection = (currentDirection+1)%4;

            for(boolean[] arr:isVisited){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("###########");
            
            i += directions[currentDirection][0];
            j += directions[currentDirection][1];
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}
