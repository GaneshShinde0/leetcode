/*
Input: (()())(())
depth = -1;
sb = ""

depth = 0;
sb = ""

depth = 1;
sb = "("

sb = ()
depth = 0

depth = 1
sb = ()(

sb = ()()
depth = 0

sb = ()()
depth = -1

sb = ()()
depth = 0

depth = 1
sb = ()()(

depth = 0;
sb = ()()()

sb = ()()()
depth = -1;

*/
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = -1;
        for(char c:s.toCharArray()){
            if(c=='(') depth++;
            if(depth!=0) sb.append(c);
            if(c==')') depth--;
            
        }
        return sb.toString();
    }
}