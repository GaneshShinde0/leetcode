class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        StringBuilder sb1 = new StringBuilder();
        Stack<StringBuilder> stk = new Stack<>();
        stk.push(sb1);
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stk.push(new StringBuilder());
            }else if(s.charAt(i)!=')'){
                stk.peek().append(s.charAt(i));
            }else{
                if(stk.size()>1){
                    StringBuilder sb = stk.pop();
                    sb.reverse();
                    stk.peek().append(sb.toString());
                }
            }
        }
        return stk.peek().toString();
    }
}