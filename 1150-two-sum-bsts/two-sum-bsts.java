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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        inOrder(root1,set);
        return check(root2,set,target);
    }
    private boolean check(TreeNode root, Set<Integer> set, int target){
        if(root==null) return false;
        int remain = target-root.val;
        if(set.contains(remain)) return true;
        return check(root.right,set,target) || check(root.left,set,target);
    }
    private void inOrder(TreeNode root, Set<Integer> set){
        if(root==null) return;
        inOrder(root.left,set);
        set.add(root.val);
        inOrder(root.right,set);
    }
}