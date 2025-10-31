import java.util.NoSuchElementException;

class Vector2D {

    // Constructor will put all the nums into this list.
    private List<Integer> nums = new ArrayList<>();
    // Keep track of where the Iterator is up to.
    private int position = 0;

    public Vector2D(int[][] v) {
        // We need to iterate over the 2D vector, getting all the integers
        // out of it and putting them into nums (a field).
        for (int[] innerVector : v) {
            for (int num : innerVector) {
                nums.add(num);
            }
        }
    }

    public int next() {
        // In Java, we throw a NoSuchElementException when next() is called
        // on an exhausted Iterator.
        if (!hasNext()) throw new NoSuchElementException();
        // Store the number we need to return, as we still need to move position forward.
        int result = nums.get(position);
        // Move the position pointer forward by 1, so that it's ready for
        // the next call to next, and gives a correct hasNext result.
        position++;
        return result;
    }

    public boolean hasNext() {
        // There's nums left as long as position is a valid index of the list.
        return position < nums.size();
    }
}
class Vector2DInitial {

    private int[][] vec;
    private int i,j;
    private int m;
    public Vector2DInitial(int[][] vec) {
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