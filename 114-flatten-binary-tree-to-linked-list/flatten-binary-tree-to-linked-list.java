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
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    private TreeNode flattenTree(TreeNode node){
        if(node==null) return null;
        if(node.left==null && node.right == null) return node;
        TreeNode leftLeaf = flattenTree(node.left);
        TreeNode rightLeaf = flattenTree(node.right);
        if(leftLeaf!=null){
            leftLeaf.right = node.right;
            node.right = node.left;
            node.left=null;
        }
        return rightLeaf==null?leftLeaf:rightLeaf;
    }
}