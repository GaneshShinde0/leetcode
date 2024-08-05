class MaximumDepthOfParenthesis {
    public int maxDepthNaive(String s) {
        int maxDepth=0;
        int currDepth=0;
        char[] schars =s.toCharArray();
        Stack<Character> stack = new Stack<>();
        if(s.length()==0) return 0;

        for(char i:schars){

            if(i=='('){
                stack.push('(');
                currDepth++;
                maxDepth=Math.max(currDepth,maxDepth);
            }
            if(stack.isEmpty()) continue;

            if (stack.peek()=='('&&i==')'){
                currDepth--;
                stack.pop();
            }
        }
        return maxDepth;
    }

    // I guess there was no need of stack
    public int maxDepth(String s) {
        int maxDepth=0;
        int currDepth=0;
        if(s.length()==0) return 0;
        for(char i:s.toCharArray()){
            if(i=='('){
                currDepth++;
                maxDepth=Math.max(currDepth,maxDepth);
            }
            if (i==')'){
                currDepth--;
            }
        }
        return maxDepth;
    }
}
