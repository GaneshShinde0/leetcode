class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String token:tokens){
            if("+-*/".indexOf(token)!=-1){
                int a = stk.pop(), b = stk.pop();
                if(token.equals("+")) stk.push(a+b);
                else if(token.equals("-")) stk.push(b-a);
                else if(token.equals("*")) stk.push(a*b);
                else if(token.equals("/")) stk.push(b/a);
            }else{
                stk.push(Integer.parseInt(token));
            }
        }
        return stk.peek();
    }
}