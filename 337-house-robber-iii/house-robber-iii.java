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
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0],res[1]); // Max of skipping or robbing the root.
    }
    private int[] helper(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        // State 0: Since we didn't rob this node we are free to either rob or SKIP the children , We greedily take maximum of children has to offer.
        int skip = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        
        // State 1: We rob the current node, since we rob the current node, we must skip the children
        int rob = root.val + left[0]+right[0];
        return new int[]{skip, rob};
    }
}
class SolutionOptimized2 {
    HashMap<TreeNode,Integer> hm;
    public int rob(TreeNode root) {
        this.hm = new HashMap<>();
        return helper(root);
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        if(hm.containsKey(root)) return hm.get(root);
        int res1 = root.val;
        if(root.left!=null){
            res1+=helper(root.left.left);
            res1+=helper(root.left.right);
        }
        if(root.right!=null){
            res1+=helper(root.right.left);
            res1+=helper(root.right.right);
        }
        int res2 = helper(root.left)+helper(root.right);
        hm.put(root, Math.max(res1,res2));
        return hm.get(root);
    }
}
class SolutionOptimized {
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