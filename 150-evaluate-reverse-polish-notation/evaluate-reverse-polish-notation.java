class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String token:tokens){
            if("+-*/".indexOf(token)!=-1){
                int t1 = stk.pop();
                int t2 = stk.pop();
                if(token.equals("+"))stk.push(t2+t1);
                if(token.equals("-"))stk.push(t2-t1);
                if(token.equals("*"))stk.push(t2*t1);
                if(token.equals("/"))stk.push(t2/t1);
            }else{
                stk.push(Integer.parseInt(token));
            }
        }
        return stk.peek();
    }
}