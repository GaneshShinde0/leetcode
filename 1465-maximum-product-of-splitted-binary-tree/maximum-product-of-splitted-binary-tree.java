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
    private static final int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        List<Long> sumAtNodes = new ArrayList<>();
        long total = totalSum(sumAtNodes, root);
        long result = 0;
        for(long sum:sumAtNodes){
            result = Math.max((total-sum)*sum,result);
        }
        return (int) (result%MOD);
    }
    private long totalSum(List<Long> sumAtNodes, TreeNode root){
        if(root==null) return 0;
        long leftSum = totalSum(sumAtNodes,root.left);
        long rightSum = totalSum(sumAtNodes,root.right);
        long currSum = root.val+leftSum+rightSum;
        sumAtNodes.add(currSum);
        return currSum;
    }
}