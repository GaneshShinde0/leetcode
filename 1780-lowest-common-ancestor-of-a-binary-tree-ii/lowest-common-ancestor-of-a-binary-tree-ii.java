/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = dfs(root, p, q);
        return count==2?res:null;
    }
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        TreeNode leftParent = dfs(root.left,p,q);
        TreeNode rightParent = dfs(root.right,p,q);
        if(root==p||root==q){
            count++;
            return root;
        }
        if(leftParent!=null && rightParent!=null) return root;
        return leftParent!=null?leftParent:rightParent;
    }
}