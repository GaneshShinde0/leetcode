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
    // Mine
    public boolean evaluateTree(TreeNode root) {
        if(root.val<2) return root.val==0?false:true;
        if(root.val==2) return evaluateTree(root.left)|| evaluateTree(root.right);
        if(root.val==3) return evaluateTree(root.left) && evaluateTree(root.right);
        return false;
    }
    // Concise
    public boolean evaluateTreeConcise(TreeNode root) {
        // Directly handle leaf nodes
        if (root.val == 0) return false;
        if (root.val == 1) return true;

        // Evaluate the children once and store the results
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        // Apply the operator based on root value (2 -> OR, 3 -> AND)
        if (root.val == 2) return left || right;  // OR operator
        if (root.val == 3) return left && right;  // AND operator

        return false; // Default return in case of unexpected input (though unnecessary)
    }
}
