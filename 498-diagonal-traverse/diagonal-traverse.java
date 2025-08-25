class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        
        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;
        
        // Incides that will help us progress through 
        // the matrix, one element at a time.
        int row = 0, column = 0;
        
        // As explained in the article, this is the variable
        // that helps us keep track of what direction we are
        // processing the current diaonal
        int direction = 1;
        
         // The final result array
        int[] result = new int[N*M];
        int r = 0;
        
        // The uber while loop which will help us iterate over all
        // the elements in the array.
        while (row < N && column < M) {
            
            // First and foremost, add the current element to 
            // the result matrix. 
            result[r++] = matrix[row][column];
            
            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if 
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);
            
            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head. 
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {
                
                // If the current diagonal was going in the upwards
                // direction.
                if (direction == 1) {
                    
                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    row += (column == M - 1 ? 1 : 0) ;
                    column += (column < M - 1 ? 1 : 0);
                        
                } else {
                    
                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }
                    
                // Flip the direction
                direction = 1 - direction;        
                        
            } else {
                
                row = new_row;
                column = new_column;
            }
        }
        return result;      
    }
    public int[] findDiagonalOrder1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int k=0;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        // We have to go over all elements in the first row and the last column to cover all possible diagonals.
        // n+m-1 basically means number of times we are changing order... or number of diagonals simply
        for(int d = 0; d<n+m-1;d++){
            // Clear the temporary array every time we start to process another diagonal.
            temp.clear();

            // We need to figure out the head of this diagonal, the element in the first row and the last column 
            // Are the respective heads.
            // Basically we are considering first (n*n) mtrix, and then the remaining matrix;
            int r = d<n?0:d-n+1;
            int c = d<n?d:n-1;

            // Iterate until one of the indices goes out of scope, take note of the index amth to go down the diagnonal.
            // We are doing following thing [i+1,j−1]
            while(r<m&&c>-1){
                temp.add(mat[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals, the question says to reverse odd numbered diagnoals but the numbering is starting from 0 to n-1
            if(d%2==0){
                Collections.reverse(temp);
            }
            for(int i=0;i<temp.size();i++){
                res[k++]=temp.get(i);
            }
        }
        return res;
    }
}

/*

initially i,j=0,0

j+=1;

i+=1;
j-=1;

i+=1;
j=0;



*/