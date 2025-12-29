class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[][] T = new int[7][7];
        Set<Long> seen = new HashSet<>();
        for(String a:allowed){
            T[a.charAt(0)-'A'][a.charAt(1)-'A'] |= 1<<(a.charAt(2)-'A');
        }
        int n = bottom.length();
        int[][] A = new int[n][n];
        int t = 0;
        for(char c:bottom.toCharArray()){
            A[n-1][t++] = c-'A';
        }
        return solve(A, 0, n-1, 0, T, seen);
    }
    //A[i] - the ith row of the pyramid
    //R - integer representing the current row of the pyramid
    //N - length of current row we are calculating
    //i - index of how far in the current row we are calculating
    //Returns true iff pyramid can be built
    public boolean solve(int[][] A, long R, int N, int i, int[][] T, Set<Long> seen){
        if(N==1 && i==1) return true; // Successfully placced pyramid
        else if (i==N){
            if(seen.contains(R)) return false; // If we have already tried this row give up.
            seen.add(R); // Add row to cache
            return solve(A,0,N-1,0, T, seen);
        }else{
            // w's jth bit is true iff block #j could be
            // a parent of A[N][i] and A[N][i+1]
            int w = T[A[N][i]][A[N][i+1]];
            // for each set bit in w...
            for (int b = 0; b < 7; ++b) if (((w >> b) & 1) != 0) {
                A[N-1][i] = b; //set parent to be equal to block #b
                //If rest of pyramid can be built, return true
                //R represents current row, now with ith bit set to b+1
                // in base 8.
                if (solve(A, R * 8 + (b+1), N, i+1, T, seen)) return true;
            }
            return false;
        }
    }
}