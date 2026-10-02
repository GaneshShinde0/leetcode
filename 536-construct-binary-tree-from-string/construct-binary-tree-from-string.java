class Solution {
    public TreeNode str2tree(String s) {
        
        if (s.isEmpty()) {
            return null;
        }
        
        TreeNode root = new TreeNode();
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        stack.add(root);
        
        for (int index = 0; index < s.length();) {
            
            TreeNode node = stack.pop();
            
            // NOT_STARTED
            if (Character.isDigit(s.charAt(index)) || s.charAt(index) == '-') {
                
                Pair<Integer, Integer> numberData = this.getNumber(s, index);
                int value = numberData.getKey();
                index = numberData.getValue();
                
                node.val = value;
                
                // Next, if there is any data left, we check for the first subtree
                // which according to the problem statement will always be the left child.
                if (index < s.length() && s.charAt(index) == '(') {
                    
                    stack.add(node);

                    node.left = new TreeNode();
                    stack.add(node.left);
                }
            } else if (s.charAt(index) == '(' && node.left != null) { // LEFT_DONE
                
                stack.add(node);

                node.right = new TreeNode();
                stack.add(node.right);
            }
            
            ++index;
        }
        
        return stack.empty() ? root : stack.pop();
        
    }
    
    public Pair<Integer, Integer> getNumber(String s, int index) {
        
        boolean isNegative = false;
        
        // A negative number
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        }
            
        int number = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            number = number * 10 + (s.charAt(index) - '0');
            index++;
        }
        
        return new Pair<Integer, Integer>(isNegative ? -number : number, index);
    } 
}