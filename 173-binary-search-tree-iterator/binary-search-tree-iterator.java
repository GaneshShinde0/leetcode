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
class BSTIteratorON {

    List<Integer> li;
    int n;
    int curr;
    public BSTIteratorON(TreeNode root) {
        li = new ArrayList<>();
        inOrder(root);
        n = li.size();
        curr=0;
    }
    private void inOrder(TreeNode root){
        if(root==null) return;
        // if(root.left==null && root.right==null) li.add(root.val);
        inOrder(root.left);
        li.add(root.val);
        inOrder(root.right);
    }
    
    public int next() {
        if(hasNext()){
            curr++;
            return li.get(curr-1);
        }
        return -1;
    }
    
    public boolean hasNext() {
        return curr<n;
    }
}

class BSTIterator{
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root){
        this.stack = new Stack<TreeNode>();
        leftMostInOrder(root);
    }

    private void leftMostInOrder(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next(){
        TreeNode topMostNode = stack.pop();
        if(topMostNode.right!=null){
            leftMostInOrder(topMostNode.right);
        }
        return topMostNode.val;
    }

    public boolean hasNext(){
        return stack.size()>0;
    }
}