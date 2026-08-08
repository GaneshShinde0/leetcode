/**
 * Definition for a binary tree root.
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
    int result;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null) return 0;
        result = 0;
        helper(root, root.val, root.val);
        return result;
    }
    private void helper(TreeNode root, int min, int max){
        if(root==null) return;
        int temp = Math.max(Math.abs(max-root.val), Math.abs(min-root.val));
        result = Math.max(temp, result);
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        helper(root.left, min, max);
        helper(root.right, min, max);
    }
}