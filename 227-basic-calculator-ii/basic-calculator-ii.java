class Solution {
    public int calculate(String s) {
        int res = 0, curr=0;
        char sign = '+';
        Stack<Integer> stk = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char c= s.charAt(i);
            if(Character.isDigit(c)){
                curr= curr*10+c-'0';
            }
            if((!Character.isDigit(c)&& !(' '==c))||i==n-1){
                if(sign=='*'){
                    stk.push(stk.pop()*curr);
                }else if(sign=='/'){
                    stk.push(stk.pop()/curr);
                }else if(sign=='+'){
                    stk.push(curr);
                }else if(sign=='-'){
                    stk.push(-curr);
                }
                sign = c;
                curr = 0;
            }
        }
        while(!stk.isEmpty()){
            res+=stk.pop();
        }
        return res;
    }
}