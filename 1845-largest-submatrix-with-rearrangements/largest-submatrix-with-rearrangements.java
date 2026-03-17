class Solution {

/*

Time Complexity
O(m*n*log(n))
Space Complexity: 
    O(n) for extra array.
    But we are also modifying matrix, so modifaction should be counted in space complexity.
    O(m*n);
*/
    public int largestSubmatrixModifiesInput(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0 && matrix[i][j]!=0) matrix[i][j]=matrix[i][j]+matrix[i-1][j];
            }

            int[] row = matrix[i].clone();
            Arrays.sort(row);
            for(int j=0;j<n;j++){
                // row is sorted in increasing order, If we have row[j], then it is bound to have values greater than or equal to in next (n-j-1) rows.
                // Considering that max square would be row[j]*(n-j)
                res = Math.max(res,row[j]*(n-j));
            }
        }
        return res;
    }
/*

Time Complexity
    O(m*n*log(n))
Space Complexity: 
    O(n) for extra array.
*/
    public int largestSubmatrixSpaceOptimized(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        int[] prevRow = new int[n];
        int ans =  0;

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(matrix[row][col]!=0) prevRow[col]+=matrix[row][col];
                else prevRow[col] = 0;
            }

            int[] sortedRow = prevRow.clone();
            Arrays.sort(sortedRow);
            for(int i=0;i<n;i++) ans = Math.max(ans,sortedRow[i]*(n-i));
        }
        return ans;
    }

    // Time and space optimized
    // Pairing height and column
    public int largestSubmatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        List<Pair<Integer, Integer>> prevHeights = new ArrayList<>();
        for(int row=0;row<m;row++){
            List<Pair<Integer, Integer>> heights = new ArrayList<>();
            boolean[] seen = new boolean[n];
            for(Pair<Integer, Integer> pair: prevHeights){
                int height = pair.getKey();
                int col = pair.getValue();
                if(matrix[row][col] == 1){
                    heights.add(new Pair(height+1,col));
                    seen[col]= true;
                }
            }
            for(int col = 0; col<n; col++){
                if(seen[col] == false && matrix[row][col]==1) heights.add(new Pair(1,col));
            }

            for(int i=0;i<heights.size();i++){
                res = Math.max(res, heights.get(i).getKey()*(i+1));
            }
            prevHeights = heights;
        }
        return res;
    }

}

