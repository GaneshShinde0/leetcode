class Solution {
    public String decodeString(String s) {
        Stack<Integer> stk = new Stack<>();
        Stack<StringBuilder> stkSB = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                n = n*10 + (c-'0');
            }else if(c == '['){
                stk.push(n);
                n = 0;
                stkSB.push(sb);
                sb=new StringBuilder();
            }else if(c == ']'){
                int k = stk.pop();
                StringBuilder temp = sb;
                sb = stkSB.pop();
                sb.append(temp.toString().repeat(k));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}