class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && temp[stk.peek()]<temp[i]){
                res[stk.peek()] = i-stk.pop();
            }
            stk.push(i);
        }
        return res;
    }
}