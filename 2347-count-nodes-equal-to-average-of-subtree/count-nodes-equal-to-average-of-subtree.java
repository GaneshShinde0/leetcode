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
    int res;
    public int averageOfSubtree(TreeNode root) {
        this.res = 0;
        sumAndCount(root);
        return res;
    }
    private int[] sumAndCount(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] arr = new int[2];
        int[] left = sumAndCount(root.left);
        int[] right = sumAndCount(root.right);
        arr[0]=left[0]+right[0]+root.val;
        arr[1]=left[1]+right[1]+1;
        if(root.val == arr[0]/arr[1]) res++;
        return arr;
    }
}