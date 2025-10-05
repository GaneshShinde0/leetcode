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
        return dfs(root,0,0);
    }
    private int dfs(TreeNode root, int total, int curr){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return curr*10+root.val;
        int left = 0,right=0;
        if(root.left!=null)left=dfs(root.left,total,curr*10+root.val);
        if(root.right!=null)right=dfs(root.right,total,curr*10+root.val);
        return left+right;

    }
}