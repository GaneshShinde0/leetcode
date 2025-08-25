class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
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