class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c:s.toCharArray()){
            if(!stk.isEmpty() && (
                (c==')' && stk.peek()=='(') ||
                (c=='}' && stk.peek()=='{') ||
                (c==']' && stk.peek()=='[')
            )){
                stk.pop();
            }else{
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }
}