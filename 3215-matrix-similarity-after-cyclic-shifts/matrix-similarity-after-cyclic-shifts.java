class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        k= k%mat[0].length;
        // if(mat.length==1) return false;
        if(k==0) return true;
        int row = mat.length, col = mat[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                // System.out.println("i:"+i+" j:"+j+", col-j-k: "+(j-k+col));
                if(i%2==0 && mat[i][j]!=mat[i][Math.abs((j-k+col)%(col))]) return false;
                if(i%2==1 && mat[i][j]!=mat[i][(j+k)%col]) return false;
            }
        }
        return true;
    }
}