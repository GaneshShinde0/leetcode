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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        else if(root.val<val){
            TreeNode node =new TreeNode(val);
            node.left = root;
            return node;
        }else if(root.right!=null && root.right.val<val){ 
            TreeNode temp = root.right;
            TreeNode node =new TreeNode(val);
            root.right = node;
            node.left = temp;
            return root;
        }else if(root.right!=null && root.right.val>val){
            insertIntoMaxTree(root.right,val);
        }else if(root.right==null){
            TreeNode node =new TreeNode(val);
            root.right = node;
            return root;
        }else{
            TreeNode temp = root.left;
            TreeNode node =new TreeNode(val);
            root.left = node;
            node.left = temp;
            return root;
        }
        return root;
    }
}