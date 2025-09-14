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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    private int dfs(TreeNode root, int maxVal){
        if(root == null) return 0;
        int res = root.val>=maxVal?1:0;
        maxVal = Math.max(maxVal,root.val);
        res+=dfs(root.left,maxVal);
        res+=dfs(root.right,maxVal);
        return res;
    }
}