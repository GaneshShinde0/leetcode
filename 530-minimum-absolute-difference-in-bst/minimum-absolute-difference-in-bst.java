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
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        addNodes(root,li);
        // System.out.println(li);
        for(int i=1;i<li.size();i++){
            res = Math.min(res,li.get(i)-li.get(i-1));
        }
        return res;
    }
    public void addNodes(TreeNode root, List<Integer> li){
        if(root.left!=null){
            addNodes(root.left,li);
        }
        li.add(root.val);
        if(root.right!=null){
            addNodes(root.right,li);
        }
        // if(root.left==null && root.right==null)return res;
        // int left=res, right =res;
        // if(root.left!=null) left= Math.min(getMinimumDifference(root.left),root.val-root.left.val);
        // if(root.right!=null) right= Math.min(getMinimumDifference(root.right),root.right.val-root.val);
        // return Math.min(left,right);
    }
}