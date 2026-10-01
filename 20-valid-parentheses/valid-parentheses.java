class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c:s.toCharArray()){
            if(!stk.isEmpty() && (
                (stk.peek()=='(' && c==')')||
                (stk.peek()=='{' && c=='}')||
                (stk.peek()=='[' && c==']')
                )
            ){
                stk.pop();
            }else if(c=='['||c=='{'||c=='('){
                stk.push(c);
            }else return false;
        }
        return stk.isEmpty();
    }
}