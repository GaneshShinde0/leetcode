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
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode root, int curr){
        if(root==null) return 0;
        curr = curr*10+root.val;
        if(root.left==null && root.right==null) return curr;
        int left = 0,right=0;
        if(root.left!=null) left=dfs(root.left,curr);
        if(root.right!=null) right=dfs(root.right,curr);
        return left+right;
    }
}