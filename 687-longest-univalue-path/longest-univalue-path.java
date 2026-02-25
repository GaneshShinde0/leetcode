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
    int longestPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return longestPath;
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        int leftDepth = 0, rightDepth=0;
        if(root.left!=null && root.left.val==root.val){
            leftDepth = helper(root.left)+1;
        }else{
            helper(root.left);
        }
        if(root.right!=null && root.right.val==root.val){
            rightDepth = helper(root.right)+1;
        }else{
            helper(root.right);
        }
        this.longestPath = Math.max(this.longestPath, leftDepth+rightDepth);
        return Math.max(leftDepth,rightDepth);
    }
}