class Solution {
    public long maxMatrixSum6ms(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int negs = 0, min = Integer.MIN_VALUE, posMin = Integer.MAX_VALUE;
        long sum = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<=0){
                    negs++;
                    min=Math.max(matrix[i][j],min);
                }else{
                    posMin = Math.min(posMin,matrix[i][j]);
                }
                sum+=Math.abs(matrix[i][j]);
            }
        }
        if(negs%2==1 && posMin>Math.abs(min)){
            return sum + 2*min;
        }else if(negs%2==1){
            return sum - 2*posMin; // As posMin is less we can reove posMin from sum
        }else{
            return sum;
        }
    }

    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int negs = 0;
        
        // Initialize minAbs to a large number so we can find the true minimum
        int minAbs = Integer.MAX_VALUE; 
        long sum = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int val = matrix[i][j];
                
                // 1. Check for negative
                if(val < 0){
                    negs++;
                }
                
                // 2. Always add absolute value to sum
                int absVal = Math.abs(val);
                sum += absVal;
                
                // 3. Track the smallest magnitude number in the ENTIRE matrix
                minAbs = Math.min(minAbs, absVal);
            }
        }

        // If odd negatives, we must sacrifice the smallest absolute number
        if(negs % 2 == 1){
            return sum - 2L * minAbs;
        } else {
            return sum;
        }
    }
}