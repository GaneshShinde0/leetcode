class Solution {
    // This wont work as we need start with current indexes height.
    public int largestRectangleAreaNA(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int maxArea = 0, n = heights.length;
        for(int i=0;i<n;i++){
            int start = i;
            while(!stk.isEmpty() && heights[stk.peek()]>heights[i]){
                maxArea = Math.max(maxArea, (i-stk.peek())*heights[i]);
                start = stk.peek();
                stk.pop();
            }
            stk.push(start);
        }
        while(!stk.isEmpty()){
            maxArea = Math.max(maxArea, (n-stk.peek())*heights[stk.peek()]);
            stk.pop();
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0, n = heights.length;
        Stack<int[]> stk = new Stack<>();

        for(int i=0;i<n;i++){
            int start = i;
            while(!stk.isEmpty() && stk.peek()[1]>heights[i]){
                int index = stk.peek()[0];
                int height = stk.peek()[1];
                maxArea = Math.max(maxArea, height*(i-index));
                stk.pop();
                start = index;
            }
            stk.push(new int[]{start, heights[i]});
        }

        while(!stk.isEmpty()){
            maxArea = Math.max(maxArea, stk.peek()[1]*(n-stk.peek()[0]));
            stk.pop();
        }
        return maxArea;
    }
}