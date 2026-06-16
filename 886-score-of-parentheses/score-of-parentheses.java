/*
Intuition and Algorithm:
- Every position in the string has a depth. Some number of matching parentheses surrounding it. For eaxample, the dot in (()(.())) has depth 2, because of these parentheses: (__(.__))
- Our goal is to maintain the score at the current depth we are on. When we see an opening bracket, we increase our depth, and our score at the new depth is 0. When we see a closing bracket, we add twice the score of the previous deeper part - except when counting (), which has a score of 1.

For Example, when counting (()(())), our stack will look like this.
- [0, 0] after parsing (
- [0, 0, 0] after (
- [0, 1] after )
- [0, 1, 0] after (
- [0, 1, 0, 0] after (
- [0, 1, 1] after )
- [0, 3] after )
- [6] after )
*/

class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0, depth = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for(char c:s.toCharArray()){
            if(c=='('){
                stk.push(0);
            }else{
                int v = stk.pop();
                int w = stk.pop();
                stk.push(w+Math.max(2*v,1));
            }
        }
        return stk.peek();
    }
}

/*
- Time Complexity: O(N), N is the length of S.
- Space Complexity: O(N), the size of the stack.
*/