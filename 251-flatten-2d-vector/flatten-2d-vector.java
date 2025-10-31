class Vector2D {

    private int[][] vec;
    private int i,j;
    private int m;
    public Vector2D(int[][] vec) {
        this.vec = vec;
        this.i=0;
        this.j=0;
        this.m = vec.length;
    }
    
    public int next() {
        int res = -1;
        if(hasNext()){
            res = this.vec[this.i][this.j];
            this.j++;
            if(this.j>=vec[i].length){
                this.j=0;
                this.i++;
            }
        }
        return res;
    }
    
    public boolean hasNext() {
        while(i<m){
            if(j<vec[i].length){
                return true;
            }
            i++;
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */