class Solution {
    // Space and Time O(n)
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        Stack<int[]> stk = new Stack<>();
        for(int i=0;i<n;i++){
            int start = i;
            while(!stk.isEmpty() && stk.peek()[1]>heights[i]){
                int index = stk.peek()[0];
                int height = stk.peek()[1];
                stk.pop();
                start = index;
                maxArea = Math.max(maxArea, height*(i-index));
            }
            stk.add(new int[]{start,heights[i]});
        }
        while(!stk.isEmpty()){
            int index = stk.peek()[0];
            int height = stk.peek()[1];
            stk.pop();
            maxArea = Math.max(maxArea, height*(n-index));
        }
        return maxArea;
    }
}