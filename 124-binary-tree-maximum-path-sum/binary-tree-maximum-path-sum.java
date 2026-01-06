
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     public int maxPathSum(TreeNode root) {
//         if(root==null) return 0;
//         if(root.left==null && root.right==null) return root.val;
//         int currSum = root.val;
//         int leftSum = maxPathSum(root.left);
//         int rightSum = maxPathSum(root.right);
//         int max = Math.max(Math.max(leftSum+rightSum+currSum, leftSum), Math.max(rightSum+leftSum+currSum, rightSum));
//         max = Math.max(max,currSum);
//         return max;
//     }
// }
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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        recurse(root);
        return max;
    }
    
    private int recurse(TreeNode root){
        if(root==null) return 0;
        // if(root.left==null && root.right==null) return root.val;
        int currSum = root.val;
        int leftSum = Math.max(recurse(root.left),0);
        int rightSum = Math.max(recurse(root.right),0);
        max = Math.max(leftSum+rightSum+root.val, max);
        return Math.max(leftSum+root.val,rightSum+root.val);
    }
}