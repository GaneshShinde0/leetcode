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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
    private int height(TreeNode root, List<List<Integer>> res){
        if(root==null) return 0;
        int level = 1+ Math.max(height(root.left,res), height(root.right,res));
        if(res.size()<level) res.add(new ArrayList<>());
        res.get(level-1).add(root.val);
        return level;
    }
}