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
    
    public int equalToDescendants(TreeNode root) {
        helper(root);
        return res;
    }
    private int helper(TreeNode root){
        if(root ==null) return 0;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        if(root.val == leftSum+rightSum) res++;
        return leftSum+rightSum+root.val;
    }
    public int equalToDescendantsInitial(TreeNode root) {
        helper1(root);
        return res;
    }
    private int helper1(TreeNode root){
        if(root ==null) return 0;
        int leftSum = helper1(root.left);
        int rightSum = helper1(root.right);
        if(root.val == leftSum+rightSum) res++;
        if(root.left==null && root.right==null) return root.val;
        return leftSum+rightSum+root.val;
    }
}