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
    private int maxZigZag = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root,'l',0);
        return maxZigZag;
    }

    private void dfs(TreeNode node, char last, int length){
        if (node==null) return;
        maxZigZag = Math.max(maxZigZag, length);
        dfs(node.left,'l',last!='l'?length+1:1);
        dfs(node.right,'r',last!='r'?length+1:1);
    }
}