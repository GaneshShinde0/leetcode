/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index;
    int n;
    public TreeNode recoverFromPreorderRecursion(String s) {
        this.index=0;
        this.n=s.length();
        return helper(s,0);
    }
    private TreeNode helper(String s, int depth){
        if(index>=n) return null;
        int dashCount = 0;
        while(index+dashCount<s.length()&&s.charAt(index+dashCount)=='-'){
            dashCount++;
        }
        if(dashCount!=depth) return null;
        index +=dashCount;

        int val = 0;
        while(index<n && Character.isDigit(s.charAt(index))){
            val=val*10+s.charAt(index++)-'0';
        }
        TreeNode node = new TreeNode(val);
        node.left = helper(s, depth+1);
        node.right = helper(s,depth+1);
        return node;
    }

    public TreeNode recoverFromPreorderUsingStack(String s){
        Stack<TreeNode> stack = new Stack<>();
        index = 0;
        n = s.length();
        while(index<s.length()){
            int depth = 0;
            while(index<n&&s.charAt(index)=='-'){
                depth++;
                index++;
            }
            int val = 0;
            while(index<s.length() && Character.isDigit(s.charAt(index))){
                val = val*10+s.charAt(index)-'0';
                index++;
            }
            TreeNode node = new TreeNode(val);
            while(stack.size()>depth){
                stack.pop();
            }
            if(!stack.empty()){
                if(stack.peek().left == null){
                    stack.peek().left = node;
                }else{
                    stack.peek().right = node;
                }
            }
            stack.push(node);
        }
        while(stack.size()>1){
            stack.pop();
        }
        return stack.peek();
    }
    public TreeNode recoverFromPreorder(String s){
        List<TreeNode> levels = new ArrayList<>();
        index = 0; n = s.length();
        while(index<n){
            int depth=0;
            while(index<n && s.charAt(index)=='-'){
                depth++;
                index++;
            }
            int val = 0;
            while(index<n && Character.isDigit(s.charAt(index))){
                val = val*10 + s.charAt(index)-'0';
                index++;
            }
            TreeNode node = new TreeNode(val);
            if(depth<levels.size()){
                levels.set(depth, node);
            }else{
                levels.add(node);
            }

            if(depth>0){
                TreeNode parent = levels.get(depth-1);
                if(parent.left==null){
                    parent.left = node;
                }else{
                    parent.right = node;
                }
            }
        }
        return levels.get(00);
    }
}
