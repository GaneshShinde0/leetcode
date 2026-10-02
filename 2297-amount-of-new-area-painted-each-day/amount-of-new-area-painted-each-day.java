class Solution {
    public int[] amountPainted(int[][] paint) {
        if (paint == null || paint.length == 0) return new int[0];
        
        int[] lines = new int[50001];
        int[] ans = new int[paint.length];
        
        for (int i=0; i<paint.length; i++) {
            int start = paint[i][0];
            int end = paint[i][1];
            while (start < end) {
                int jump = Math.max(start + 1, lines[start]);
                ans[i] += lines[start] == 0 ? 1 : 0;
                lines[start] = Math.max(lines[start], end);
                start = jump;
            }
        }
        return ans;
    }
}