class Solution {
    public int calculate(String s) {
        int res = 0;
        int sign = 1, curr = 0;
        Stack<Integer> stk = new Stack<>();
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                curr = curr *10+c-'0';
            }else if(c=='+'||c=='-'){
                res+=sign*curr;
                if(c=='+') sign=1;
                else sign = -1;
                curr=0;
            }else if(c=='('){
                stk.add(res);
                stk.add(sign);
                sign = 1;
                res = 0;
            }else if (c==')'){
                res+=sign*curr;
                res*=stk.pop();
                res+=stk.pop();
                curr = 0;
            }
        }
        return res+sign*curr;
    }
}