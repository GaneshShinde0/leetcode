class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, left = 0, right = n-1, bottom = m-1;

        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++) result.add(matrix[top][i]);
            top++;
            for(int i=top;i<=bottom;i++) result.add(matrix[i][right]);
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--) result.add(matrix[bottom][i]);
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }
}