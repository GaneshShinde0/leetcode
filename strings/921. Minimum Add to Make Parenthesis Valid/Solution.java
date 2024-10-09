class Solution {
    // Stack is more beneficial when we are solving for multiple types of parenthesis
    public int minAddToMakeValidUsingStack(String s) {
        char[] stack = new char[1000];
        int stkptr=0;
        stack[stkptr]=s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')' && stkptr>=0 && stack[stkptr]=='('){
                stkptr--;
            }else{
                stkptr++;
                stack[stkptr]=s.charAt(i);
            }
        }
        return stkptr+1;
    }

    public int minAddToMakeValid(String s) {
        int minAdd=0;
        int openParenthesis=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')' ){
                if(openParenthesis>0){
                    openParenthesis--;
                }else{
                    minAdd++;
                }
            }else{
                openParenthesis++;
            }
        }
        return minAdd+openParenthesis;
    }
}
