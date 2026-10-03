class Solution {
    public int longestValidParentheses(String s) {
        int res = 0, n = s.length();
        int[] dp = new int[n];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = (i>=2?dp[i-2]:0)+2;
                }else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='('){
                    dp[i] = dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public int longestValidParenthesesUsingStack(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int n = s.length(), res = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') stk.push(i);
            else{
                stk.pop();
                if(stk.isEmpty()){
                    stk.push(i);
                }else{
                    res = Math.max(res, i-stk.peek());
                }
            }
        }
        return res;
    }
    public int longestValidParenthesesWithoutSpace(String s) {
        Stack<Character> stk = new Stack<>();
        int left = 0, right = 0, res = 0, n = s.length();
        for(int i=right;i<n;i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                res = Math.max(res, left+right);
            }else if(right>left){
                right = 0;
                left = 0;
            }
        }
        left = 0;
        right = 0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==')'){
                right++;
            }else{
                left++;
            }
            if(left==right){
                res = Math.max(res, left+right);
            }else if(left>right){
                left=0;
                right=0;
            }
        }
        return res;
    }
}