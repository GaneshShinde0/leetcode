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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> li =  new ArrayList<>();
        getNodesOfTree(li,root);
        return getBalancedTree(li,0, li.size()-1);
    }
    private void getNodesOfTree(List<Integer> li, TreeNode root){
        if(root==null) return;
        getNodesOfTree(li, root.left);
        li.add(root.val);
        getNodesOfTree(li, root.right);
    }
    private TreeNode getBalancedTree(List<Integer> li, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode leftSubTree = getBalancedTree(li,start,mid-1);
        TreeNode rightSubTree = getBalancedTree(li,mid+1,end);
        return new TreeNode(li.get(mid),leftSubTree, rightSubTree);
    }
}