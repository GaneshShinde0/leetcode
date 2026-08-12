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
    String smallest = "z".repeat(85);
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recurse(root, sb);
        return smallest;
    }
    private void recurse(TreeNode root, StringBuilder sb){
        if(root==null) return;
        sb.append((char) (root.val+'a'));
        if(root.left==null && root.right==null){
            this.smallest = sb.reverse().toString().compareTo(smallest)<0?sb.toString():smallest;
            sb.reverse();
            return;
        }
        recurse(root.left,sb);
        if(root.left!=null) sb.deleteCharAt(sb.length()-1);
        recurse(root.right,sb);
        if(root.right!=null) sb.deleteCharAt(sb.length()-1);
    }
}