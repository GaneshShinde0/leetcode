class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<>();
        for(String s:tokens){
            if("+-/*".contains(s)){
                int n1 = Integer.parseInt(stk.pop());
                int n2 = Integer.parseInt(stk.pop());
                if(s.equals("+")) stk.push(String.valueOf(n1+n2));
                if(s.equals("-")) stk.push(String.valueOf(n2-n1));
                if(s.equals("*")) stk.push(String.valueOf(n1*n2));
                if(s.equals("/")){
                    stk.push(String.valueOf(n2/n1));
                    // System.out.println(n1/n2);
                }
            }else{
                stk.push(s);
            }
        }
        return Integer.parseInt(stk.pop());
    }
}