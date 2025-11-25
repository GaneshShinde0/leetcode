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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> li = new ArrayList<>();
        dfs(root, targetSum, li, new ArrayList<>());
        return li;
    }
    private void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> curr){
        if(root==null) return;
        curr.add(root.val);
        if(root!=null && root.left==null && root.right==null && targetSum==root.val){
            res.add(curr);
        }else{
            dfs(root.left,targetSum-root.val,res,new ArrayList<>(curr));
            dfs(root.right,targetSum-root.val,res,new ArrayList<>(curr));
        }
    }
}