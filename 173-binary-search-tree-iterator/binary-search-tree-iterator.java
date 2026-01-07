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
class BSTIterator {

    List<Integer> li;
    int n;
    int curr;
    public BSTIterator(TreeNode root) {
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
