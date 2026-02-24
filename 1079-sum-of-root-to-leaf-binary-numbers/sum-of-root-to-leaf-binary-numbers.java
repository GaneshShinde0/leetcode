
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
    int globalSum;
    public int sumRootToLeaf(TreeNode root) {
        this.globalSum = 0;
        helper(root,0);
        return globalSum;
    }
    private void helper(TreeNode root, int sum){
        if(root==null) return;
        if(root.left==null && root.right==null)this.globalSum+=sum*2+root.val;
        else{
            if(root.left!=null) helper(root.left,sum*2+root.val);
            if(root.right!=null) helper(root.right,sum*2+root.val);
        }
    }
}