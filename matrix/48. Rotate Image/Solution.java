class Solution {
    public void rotateInitial(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                matrix[i][j]=matrix[j][i]+matrix[i][j];
                matrix[j][i]=matrix[i][j]-matrix[j][i];
                matrix[i][j]=matrix[i][j]-matrix[j][i];
                System.out.println(matrix[i][j]);
                System.out.println(matrix[j][i]);
            }
        }

        for(int r=0; r<matrix.length; r++) {
            int left = 0;
            int right = matrix.length-1;

            while(left < right) {
                int temp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = temp;

                left++;
                right--;
            }
        }
    }

    public void rotate(int[][] m){
        int n = m.length;
        for(int i=0;i<n/2;i++){
            int len = n-2*i-1, opp = n-i-1;
            for(int j = 0; j<len; j++){
                int temp  = m[i][i+j];
                m[i][i+j] = m[opp-j][i];
                m[opp-j][i]=m[opp][opp-j];
                m[opp][opp-j]=m[i+j][opp];
                m[i+j][opp] = temp;
            }
        }
    }
}

/*
a=7,b=3
a=a+b = 10
b=a-b = 10-3 = 7
a=a-b = 10-7 = 3
*/
