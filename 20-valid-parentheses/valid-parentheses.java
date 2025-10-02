class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stk.isEmpty()){
                char top = stk.peek();
                char curr = s.charAt(i);
                if((top == '('&& curr==')' ) ||
                    (top == '[' && curr==']' ) ||
                    (top == '{' && curr== '}' )){
                    stk.pop();
                }else{
                    stk.push(curr);
                }
            }else{
                stk.push(s.charAt(i));
            }
        }   
        return stk.isEmpty();
    }
}