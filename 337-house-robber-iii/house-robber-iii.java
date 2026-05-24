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
    HashMap<TreeNode,Integer> hm;
    public int rob(TreeNode root) {
        this.hm = new HashMap<>();
        return helper(root,0);
    }
    private int helper(TreeNode root, int curr){
        if(root==null) return curr;
        if(hm.containsKey(root)) return hm.get(root);
        int res1 = root.val;
        if(root.left!=null){
            res1+=helper(root.left.left,0);
            res1+=helper(root.left.right,0);
        }
        if(root.right!=null){
            res1+=helper(root.right.left,0);
            res1+=helper(root.right.right,0);
        }
        int res2 = helper(root.left,0)+helper(root.right,0);
        hm.put(root, Math.max(curr+res1,curr+res2));
        return Math.max(curr+res1,curr+res2);
    }
}
class SolutionInitial {
    public int rob(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode root, int curr){
        if(root==null) return curr;
        int res1 = root.val;
        if(root.left!=null){
            res1+=helper(root.left.left,0);
            res1+=helper(root.left.right,0);
        }
        if(root.right!=null){
            res1+=helper(root.right.left,0);
            res1+=helper(root.right.right,0);
        }
        int res2 = rob(root.left)+rob(root.right);
        return Math.max(curr+res1,curr+res2);
    }
}