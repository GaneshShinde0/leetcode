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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap(), res);
        return res;
    }

    private String traverse(TreeNode root, Map<String, Integer> cnt, List<TreeNode> res){
        if(root==null) return "";
        String curr = root.val +","+ traverse(root.left, cnt, res) +","+ traverse(root.right, cnt, res);
        cnt.put(curr, cnt.getOrDefault(curr,0)+1);
        if(cnt.get(curr)==2){
            res.add(root);
        }
        return curr;
    }
}