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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();
        return getLeafNodes(root1,li1).equals(getLeafNodes(root2,li2));
    }
    public List<Integer> getLeafNodes(TreeNode root, List<Integer> li){
        if(root.left==null && root.right==null){
            li.add(root.val);
            return li;
        }
        if(root.left!=null){
            getLeafNodes(root.left, li);
        }
        if(root.right!=null){
            getLeafNodes(root.right, li);
        }
        return li;
    }
}