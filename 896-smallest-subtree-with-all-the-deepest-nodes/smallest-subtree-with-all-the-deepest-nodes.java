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
    Map<TreeNode, Integer> depth;
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap<>();
        depth.put(null,-1);
        maxDepth=-1;
        dfs(root, null);
        for(int d: depth.values()) maxDepth = Math.max(maxDepth,d);
        return answer(root);
    }

    public void dfs(TreeNode node, TreeNode parent){
        if(node!=null){
            depth.put(node, depth.get(parent)+1);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }

    public TreeNode answer(TreeNode node){
        if(node==null || depth.get(node)==maxDepth) return node;
        TreeNode L = answer(node.left), R = answer(node.right);
        if(L!=null && R != null) return node;
        if(L != null) return L;
        if(R != null) return R;
        return null;
    }
}