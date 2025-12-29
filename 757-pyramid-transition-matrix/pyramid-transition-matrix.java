class Solution {
    Map<String, List<Character>> map = new HashMap<>();
    Map<String, Boolean> memo = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return solve(bottom);
    }

    private boolean solve(String bottom) {
        if (bottom.length() == 1) return true;
        if (memo.containsKey(bottom)) return memo.get(bottom);

        // Try to generate a valid next row and solve recursively
        boolean result = generateNextRow(bottom, 0, new StringBuilder());
        memo.put(bottom, result);
        return result;
    }

    // Helper to generate next row candidates (DFS within the level)
    private boolean generateNextRow(String bottom, int idx, StringBuilder currentNext) {
        if (idx == bottom.length() - 1) {
            // Full next row built, proceed to next level
            return solve(currentNext.toString());
        }

        String key = bottom.substring(idx, idx + 2);
        if (!map.containsKey(key)) return false;

        for (char val : map.get(key)) {
            currentNext.append(val);
            if (generateNextRow(bottom, idx + 1, currentNext)) return true;
            currentNext.deleteCharAt(currentNext.length() - 1); // backtrack
        }
        
        return false;
    }

    public boolean pyramidTransitionNotReadable(String bottom, List<String> allowed) {
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