class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<List<Integer>> li = new ArrayList<>();
        for(int i=0;i<m+n-1;i++){
            List<Integer> curr = new ArrayList<>();
            int row = Math.max(0,i-n);
            int col = Math.max(0,n-i-1);
            while(row<m && col<n){
                curr.add(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(curr);
            row = Math.max(0,i-n);
            col = Math.max(0,n-i-1);
            int j = 0;
            while(row<m && col<n){
                mat[row][col]=curr.get(j);
                row++;
                col++;
                j++;
            }
        }
        return mat;
    }
}