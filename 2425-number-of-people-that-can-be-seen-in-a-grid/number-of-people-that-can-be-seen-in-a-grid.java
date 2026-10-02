class Solution {
    public int[][] seePeople(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < n; i++){ // DOWN
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = m - 1; j >= 0; j--){
                while(!stack.isEmpty() && heights[j][i] > stack.peek()){
                    ans[j][i]++;
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    ans[j][i]++;
                }
                if (stack.isEmpty() || heights[j][i] != stack.peek()){
                    stack.push(heights[j][i]);
                }
            }
        }

        for (int i = 0; i < m; i++){ // RIGHT
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = n - 1; j >= 0; j--){
                while(!stack.isEmpty() && heights[i][j] > stack.peek()){
                    ans[i][j]++;
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    ans[i][j]++;
                }
                if (stack.isEmpty() || heights[i][j] != stack.peek()){
                    stack.push(heights[i][j]);
                }
            }
        }

        return ans;
    }
}