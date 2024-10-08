class Solution {

  public int minSwapsUsingStackNaive(String s) {
        Stack<Character> stk = new Stack<>();

        // Iterate through the string to identify unbalanced closing brackets.
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // If it's an opening bracket, push it onto the stack.
            if (currentChar == '[') {
                stk.push(currentChar);
            } else if (currentChar == ']') {
                // If we encounter a closing bracket and the stack is not empty, 
                // check if the top is an opening bracket.
                if (!stk.isEmpty() && stk.peek() == '[') {
                    stk.pop(); // Remove the matching pair.
                } else {
                    // Unbalanced closing bracket, push it to the stack.
                    stk.push(currentChar);
                }
            }
        }

        // Now the stack contains only unbalanced brackets.
        // Every swap can fix two unbalanced brackets.
        // Return the number of swaps needed to balance the expression.
        return (int) Math.ceil(stk.size() / 2.0);
    }
    public int minSwapsUsingStack(String s) {
        // Length of expression, 10^6: Brute Force wont work here
        // For Expression to be balanced first half should be balanced and so does the second half.
        // When we solve it normally we basically check how many ] brackets are there before [
        // I.E. Unbalanced closing brackets [ that dont have matching opening brackets.
        
        // Approach
        // We will first remove all the balanced, this will will also be slow... So this is out of scope.
        
        // One swap means two brackets will be balanced i.e. ]][[ -> [][]
        // Other Example ]]]][[[[ -> ]][][][[ -> [][][][] (Total 2 swaps).
        // In cases where some substrings are balanced just remove them so that we are left with something like ]]]]...[[[[...
        // So may be we need to calculate number of ] brackets that are before [ and return math.ceil(count/2);

        Stack<Character> stk = new Stack<>();
        // stk.push(s.charAt(0));
        // for(int i=1;i<s.length();i++){
        //     if(s.charAt(i)==']' && stk.peek()==']'){
        //         stk.push(']');
        //     }else if (s.charAt(i)==']' && stk.peek()=='['){
        //         stk.pop();
        //     }
        //     System.out.println(stk);
        // }
        stk.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='['){
                stk.push('[');
            }else if (s.charAt(i)==']' && !stk.isEmpty()){
                stk.pop();
            }
        }
        return (int) Math.ceil(stk.size()/2.0);
    }

    public int minSwaps(String s) {
        int stackSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If character is opening bracket, increment the stack size.
            if (ch == '[') stackSize++;
            else {
                // If the character is closing bracket, and we have an opening bracket, decrease
                // the stack size.
                if (stackSize > 0) stackSize--;
            }
        }
        return (stackSize + 1) / 2;
    }
}
