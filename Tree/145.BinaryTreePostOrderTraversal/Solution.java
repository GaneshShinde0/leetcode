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
    List<Integer> li = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root!=null && root.left!=null) postorderTraversal(root.left);
        if (root!=null && root.right!=null) postorderTraversal(root.right);
        if (root!=null) li.add(root.val);
        return li;
    }

    public List<Integer> postorderTraversalUsingHelper(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrderTraversal(ans, root);
        return ans;
    }
    
    private void postOrderTraversal(List<Integer> arr, TreeNode root) {
        if(root != null) {
            postOrderTraversal(arr, root.left);
            postOrderTraversal(arr, root.right);
            arr.add(root.val);
        }
    }
}
