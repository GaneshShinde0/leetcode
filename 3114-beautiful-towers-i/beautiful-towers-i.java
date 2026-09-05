class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long[] totalBricksOnLeft = new long[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[stk.peek()]>heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                totalBricksOnLeft[i] = 1l*(i+1)*heights[i];
            }else{
                int j = stk.peek();
                totalBricksOnLeft[i] = totalBricksOnLeft[j]+1l*(i-j)*heights[i];
            }
            stk.push(i);
        }

        long[] totalBricksOnRight = new long[n];
        stk.clear();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && heights[stk.peek()]>heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                totalBricksOnRight[i] = 1l*(n-i)*heights[i];
            }else{
                int j = stk.peek();
                totalBricksOnRight[i] = totalBricksOnRight[j]+1l*(j-i)*heights[i];
            }
            stk.push(i);
        }

        // System.out.println(Arrays.toString(totalBricksOnLeft));
        // System.out.println(Arrays.toString(totalBricksOnRight));
        long res = 0;
        for(int i=0;i<n;i++){
            res = Math.max(res, totalBricksOnLeft[i]+totalBricksOnRight[i]-heights[i]);
        }
        return res;
    }
}