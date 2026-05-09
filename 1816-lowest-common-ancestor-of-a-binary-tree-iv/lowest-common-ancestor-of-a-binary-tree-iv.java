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
    Set<TreeNode> set;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        set = new HashSet<>();
        for(TreeNode node:nodes) set.add(node);
        return dfs(root, nodes,set);
    }
    private TreeNode dfs(TreeNode root, TreeNode[] nodes, Set<TreeNode> set){
        if(root == null  || set.contains(root)) return root;
        TreeNode left = dfs(root.left, nodes, set);
        TreeNode right = dfs(root.right, nodes, set);
        if(left != null && right != null) return root;
        return left!=null?left:right;
    }                                                              
}