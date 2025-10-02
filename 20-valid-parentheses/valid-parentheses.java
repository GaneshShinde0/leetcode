class Solution {
    public boolean isValidInitial(String s) {
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
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;
                char top = stk.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}