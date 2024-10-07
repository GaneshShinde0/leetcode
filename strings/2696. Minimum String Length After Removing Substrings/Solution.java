class Solution {
    public int minLengthUsingStack5ms(String s) {
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));

        for(int i=1;i<s.length();i++){
            if(!stk.isEmpty()&&((stk.peek()=='A' && s.charAt(i)=='B')||(stk.peek()=='C' && s.charAt(i)=='D'))){
                stk.pop();
            }else{
                stk.push(s.charAt(i));
            }
        }

        return stk.size();
    }

    public int minLengthUsingReplaceAllTakes27ms(String s) {
        
        while(s.indexOf("AB")!=-1 || s.indexOf("CD")!=-1){
            s=s.replaceAll("AB","");
            s=s.replaceAll("CD","");
        }
    }

    public int minLength(String s) {
        char[] stack = new char[s.length()+1];
        int last = -1;
        for (char c : s.toCharArray()) {
            if (last > -1 && (c == 'B' && stack[last] == 'A' || 
                                     c == 'D' && stack[last] == 'C')) 
            {
                last--;
            } else {
                last++;
                stack[last] = c;
            }
        }
        return last+1;
    }
}
