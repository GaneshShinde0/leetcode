class Solution {
    public String minRemoveToMakeValidUsingStringBuilder(String s) {
        StringBuilder sb = new StringBuilder();
        int opens = 0;
        for(char c:s.toCharArray()){
            if(opens==0 && c==')') {
                continue;
            }
            if(c=='(') opens++;
            if(c==')') opens--;
            sb.append(c);
        }
        int i=sb.length()-1;
        while(i>=0 && opens>0){
            if(sb.charAt(i)=='('){
                opens--;
                sb.deleteCharAt(i);
            }
            i--;
        }
        return sb.toString();
    }
    public String minRemoveToMakeValid(String s){
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            if(s.charAt(i)==')'){
                if(stack.isEmpty()) indexesToRemove.add(i); // Stack is Empty and we have openning parenthesis.
                else stack.pop();
            }
        }

        // Put any indexes remaining on stack into the set.
        while(!stack.isEmpty()) indexesToRemove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!indexesToRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}