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

/*
If you see the simulated diagrams you will see previously tree is starting from root and is coming all the way to the leaf nodes.
We need tree which is startign from left most node and projecting all the way to root and right nodes.
*/
class Solution {
    public TreeNode upsideDownBinaryTreeRecursive(TreeNode root) {
        if(root == null || root.left==null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left); 
        root.left.left = root.right; // Node to left children.
        root.left.right = root; // Node to right children.
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root){
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;

        while(curr!=null){
            next = curr.left;

            // Swapping nodes now, need temp to keep the previous right children
            curr.left = temp;;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}