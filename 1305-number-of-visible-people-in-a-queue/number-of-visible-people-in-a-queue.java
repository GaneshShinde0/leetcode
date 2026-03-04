class Solution {
    public int[] canSeePersonsCountDoesNotWork(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--){
            res[i]=stk.size();
            while(!stk.isEmpty()&&res[i]>stk.peek()){
                stk.pop();
            }
            stk.push(res[i]);
        }
        return res;
    }

    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length, res[] = new int[n];
        Stack<Integer> stack = new Stack();
        for(int i=0;i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()]<=heights[i]){
                res[stack.pop()]++;
            } 
            if(!stack.isEmpty()){
                res[stack.peek()]++;
            }
            stack.add(i);
        }
        return res;
    }
}
/*
Input: heights = [10,6,8,5,11,9]
res = [0]
Stk = [9]

res = [1  0]
Stk = [11]

res = [1 1  0]
Stk = [11 5]

res = [2 1 1 0]
stk = [11 8]
*/