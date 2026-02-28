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
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return  res;
        isUniValue(root);
        return res;
    }

    private boolean isUniValue(TreeNode root){
        boolean left = true, right = true;
        if(root.left!=null) left = isUniValue(root.left);
        if(root.right!=null) right = isUniValue(root.right);
        if(root.left!=null && root.left.val!=root.val) return false;
        if(root.right!=null && root.right.val!=root.val) return false;
        if(left&&right) this.res++;
        return left&&right;
    }
}