class Solution {
    public int findBlackPixel(char[][] picture, int target) {
        int m = picture.length, n = picture[0].length, res = 0;
        int[] row = new int[m];
        int[] col = new int[n];
        // Map to store the string representation of rows and their counts
        Map<String, Integer> map = new HashMap<>();

        // Pass 1: Populate row/col counts and the row string map
        for(int i = 0; i < m; i++) {
            // Convert the current row to a String to use as a key
            String rowStr = new String(picture[i]);
            map.put(rowStr, map.getOrDefault(rowStr, 0) + 1);

            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        // Pass 2: Check all conditions
        for(int i = 0; i < m; i++) {
            String rowStr = new String(picture[i]);
            
            for(int j = 0; j < n; j++) {
                // Rule 1: row[i] == target && col[j] == target
                // Rule 2: map.get(rowStr) == target 
                // (This ensures that there are exactly 'target' rows identical to this one)
                if(picture[i][j] == 'B' && 
                   row[i] == target && 
                   col[j] == target && 
                   map.get(rowStr) == target) {
                    res++;
                }
            }
        }
        return res;
    }
}

/*
[
["W","B","W","B","B","W"],
["B","W","B","W","W","B"],
["W","B","W","B","B","W"],
["B","W","B","W","W","B"],
["W","W","W","B","B","W"],
["B","W","B","W","W","B"]]
*/