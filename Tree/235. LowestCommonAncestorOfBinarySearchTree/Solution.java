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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // This is binary search tree.
        // This will all the elements greater than root on the right side,
        // All the elements less that root on the left side.
        if(root == p || root == q){
            return root;
        }else if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if (p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }
}
