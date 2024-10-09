class N20ValidParenthesis {
    public boolean isValidNaiveApproach(String s) {
        char[] c = s.toCharArray();
        Stack<Character> s1 = new Stack<>();
        for(int i=0;i<c.length;i++){
            if(!s1.isEmpty()&&((s1.peek()=='('&&c[i]==')')||(s1.peek()=='{'&&c[i]=='}')||(s1.peek()=='['&&c[i]==']'))){
                    s1.pop();
                }else{
                    s1.push(c[i]);
                }
        }
        return s1.isEmpty();
    }

    public boolean isValidUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (!stack.isEmpty() && 
                       ((ch == ')' && stack.peek() == '(') ||
                        (ch == '}' && stack.peek() == '{') ||
                        (ch == ']' && stack.peek() == '['))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    // Following implementation uses character array and simulates it as stack and is fastet
    public boolean isValid(String s) {
        int i = -1;
        char[] stack = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack[++i] = ch;
            else {
                if (i >= 0
                    && ((stack[i] == '(' && ch == ')')
                        || (stack[i] == '{' && ch == '}')
                        || (stack[i] == '[' && ch == ']')))
                    i--;
                else
                    return false;
            }
        }
        return i == -1;
    }
}
