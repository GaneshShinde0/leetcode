class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int[] row:matrix) reverse(row);
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i;j++){
                swap(matrix,i,j,n-j-1,n-i-1);
            }
        }
    }
    private void reverse(int[] arr){
        int start = 0, end = arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    private void swap(int[][] matrix, int i, int j, int newI, int newJ){
        int temp = matrix[i][j];
        matrix[i][j]=matrix[newI][newJ];
        matrix[newI][newJ]=temp;
    }
}