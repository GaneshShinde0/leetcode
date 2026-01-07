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
        List<Long> sums = new ArrayList<>();
        long totalSum = totalSum(root,sums);
        long maxProd = 0;
        for(long sum:sums){
            maxProd = Math.max(maxProd,(totalSum-sum)*sum);
        }
        return (int) (maxProd%MOD);
    }
    private long totalSum(TreeNode root,List<Long> sums){
        if(root==null) return 0;
        long leftSum = totalSum(root.left,sums);
        long rightSum = totalSum(root.right,sums);
        long currSum = root.val+leftSum+rightSum;
        sums.add(currSum);
        return currSum;
    }
}