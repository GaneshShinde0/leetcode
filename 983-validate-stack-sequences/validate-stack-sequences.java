class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for(int num:pushed){
            pushed[i++] = num;
            while(i>0 && pushed[i-1]==popped[j]){
                j++;
                i--;
            }
        }
        return i==0;
    }
    public boolean validateStackSequencesUsingStack(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack();
        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == N;
    }
}