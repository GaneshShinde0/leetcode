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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> q = new ArrayList<>();
        if(root==null)return res;
        q.add(root);
        int curr=0;
        while(q.size()>curr){
            List<Integer> li = new ArrayList<>();
            int size = q.size();
            for(;curr<size;curr++){
                TreeNode node = q.get(curr);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                li.add(node.val);
            }
            res.add(li);
        }
        return res;
    }

}