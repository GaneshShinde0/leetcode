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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    public boolean dfs(TreeNode root, int[] arr, int curr){
        if(curr==arr.length-1 && root!=null && root.val == arr[curr] && root.left==null && root.right==null) return true;
        if(root==null || curr==arr.length) return false;
        if(root.val==arr[curr])
            return dfs(root.left,arr,curr+1)||dfs(root.right,arr, curr+1);
        return false;
    }
    
}