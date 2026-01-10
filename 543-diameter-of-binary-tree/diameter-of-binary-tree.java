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
    int depth;
    public int diameterOfBinaryTree(TreeNode root) {
        depth = 0;
        dfs(root);
        return depth;
    }
    public int dfs(TreeNode root){
        if(root==null) return -1;
        int left = -1,right=-1;
        if(root.left!=null) left = dfs(root.left);
        if(root.right!=null) right = dfs(root.right);
        depth = Math.max(depth,left+right+2);
        return Math.max(left,right)+1;
    }
}