/**
 * Definition for a binary tree root.
 * public class Treeroot {
 *     int val;
 *     Treeroot left;
 *     Treeroot right;
 *     Treeroot() {}
 *     Treeroot(int val) { this.val = val; }
 *     Treeroot(int val, Treeroot left, Treeroot right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return root;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left==null && root.right==null && root.val==0){
            root=null;
            return root;
        } 
        return root;
    }
}