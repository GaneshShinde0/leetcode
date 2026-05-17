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
class Solution1 {
    private boolean isValidBST(TreeNode root){
        if(root==null) return true;
        int leftMax = findMax(root.left);
        int rightMin = findMin(root.right);
        if(leftMax>=root.val || rightMin<=root.val) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private int findMax(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(Math.max(root.val,findMax(root.left)),findMax(root.right));
    }
    private int findMin(TreeNode root){
        if(root==null) return Integer.MAX_VALUE;
        return Math.min(Math.min(root.val,findMin(root.left)),findMin(root.right));
    }
    private int countNodes(TreeNode root){
        if(root==null) return 0;
        return 1+ countNodes(root.left)+countNodes(root.right);
    }
    public int largestBSTSubtree(TreeNode root) {
        if(root==null) return 0;
        if(isValidBST(root)) return countNodes(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
}

class NodeValue{
    public int maxNode, minNode, maxSize;
    NodeValue(int minNode, int maxNode, int maxSize){
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}

class Solution{
    public NodeValue largestBSTSubtreeHelper(TreeNode root){
        if(root==null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        NodeValue left= largestBSTSubtreeHelper(root.left);
        NodeValue right= largestBSTSubtreeHelper(root.right);

        if(left.maxNode<root.val && root.val<right.minNode){
            return new NodeValue(Math.min(root.val,left.minNode), Math.max(root.val, right.maxNode), left.maxSize+right.maxSize+1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize,right.maxSize));
    }

    public int largestBSTSubtree(TreeNode root){
        return largestBSTSubtreeHelper(root).maxSize;
    }
}