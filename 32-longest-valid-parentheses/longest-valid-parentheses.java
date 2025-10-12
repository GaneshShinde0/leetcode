class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        int left =0, right = 0, res=0, n = s.length();
        for(int i=right;i<n;i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                res = Math.max(res,left+right);
            }else if (right>left){
                left = right = 0;
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

            if(left == right){
                res = Math.max(res,left+right);
            }else if(left>right){
                left = right=0;
            }
        }
        return res;
    }
}