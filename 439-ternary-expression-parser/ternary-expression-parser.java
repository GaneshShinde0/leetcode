class Solution {
    public String parseTernary(String exp) {
        boolean flag = exp.charAt(0)=='T';
        Stack<Character> stk = new Stack<>();
        int n = exp.length();

        for(int i=0;i<exp.length();i++){
            char curr = exp.charAt(n-i-1);
            // Push every T, F and digit on the sack
            if(curr>='0'&&curr<='9' || curr=='T'||curr=='F') stk.push(curr);
            else if(curr=='?'){
                char onTrue = stk.pop();
                char onFalse = stk.pop();
                stk.push(exp.charAt(n-i-2)=='T'?onTrue:onFalse);
                i++;
            }
        }
        return String.valueOf(stk.peek());
    }
}