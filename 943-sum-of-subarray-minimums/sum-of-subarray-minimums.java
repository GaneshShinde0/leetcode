/*
Input: arr = [3,1,2,4]
3+1+1+1
1+1+1
2+2
4

1+1+1+1
2+2+2
3+3
4


*/

class Solution {
    private static final int MOD = 1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long sumOfMinimums = 0;

        for(int i=0;i<=arr.length;i++){
            while(!stack.empty() && (i==arr.length || arr[stack.peek()]>=arr[i])){
                
                int mid = stack.pop();
                int leftBoundary = stack.empty()? -1 : stack.peek();
                int rightBoundary = i;
                long count = (mid-leftBoundary)*(rightBoundary-mid)%MOD;
                sumOfMinimums += (count*arr[mid])%MOD;
                sumOfMinimums %= MOD;
            }
            stack.push(i);
        }
        return  (int) (sumOfMinimums);
    }
}