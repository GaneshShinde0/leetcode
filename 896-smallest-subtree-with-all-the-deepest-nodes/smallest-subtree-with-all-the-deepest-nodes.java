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
        if(L!=null && R != null) return node; // Both Left and Right have a node with max Value (we will return node)
        if(L != null) return L; // Left Has Node with max value; return Left
        if(R != null) return R;  // Right has node with max value; return right;
        return null; // Null found return null
    }
}

class SolutionAlternate {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);
        Result L = dfs(node.left),
               R = dfs(node.right);
        if (L.dist > R.dist) return new Result(L.node, L.dist + 1);
        if (L.dist < R.dist) return new Result(R.node, R.dist + 1);
        return new Result(node, L.dist + 1);
    }
}

/**
 * The result of a subtree is:
 *       Result.node: the largest depth node that is equal to or
 *                    an ancestor of all the deepest nodes of this subtree.
 *       Result.dist: the number of nodes in the path from the root
 *                    of this subtree, to the deepest node in this subtree.
 */
class Result {
    TreeNode node;
    int dist;
    Result(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}