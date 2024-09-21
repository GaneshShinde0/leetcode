class Solution {
    public int numberOfChildNaive(int n, int k) {
        int ptr=1;
        int dir = 1;
        for(int i=1;i<k;i++){
            if(i%(n-1)==0){
                dir*=-1;
            }
            ptr+=dir;
        }
        return ptr;
    }

    public int numberOfChild(int n, int k) {
        n--; // Decrement n to simplify calculation (so range is now 0 to n-1)
        int rounds = k / n; // Calculate the number of complete back-and-forth trips
        int rem = k % n; // Calculate the remaining steps after the last complete trip

        if (rounds % 2 == 0) {
            // If the number of complete back-and-forth trips is even
            return rem; // The ball is passed forward from the start
        } else {
            // If the number of complete back-and-forth trips is odd
            return n - rem; // The ball is passed backward from the end
        }
    }
}
