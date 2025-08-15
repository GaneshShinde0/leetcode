class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&& temp[stack.peek()]<temp[i]){
                res[stack.peek()]=i-stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}