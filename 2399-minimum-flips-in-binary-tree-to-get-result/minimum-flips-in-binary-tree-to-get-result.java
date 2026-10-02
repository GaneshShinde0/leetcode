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

    record Flips(int forTrue, int forFalse) {}

    public int minimumFlips(TreeNode root, boolean result) {
        
        Flips flips = minFlips(root);
        if (result) {
            return flips.forTrue();
        }
        return flips.forFalse();
    }

    Flips minFlips(TreeNode root) {
        if (root.val == 0) {
            // since node is false, we need one flip to eval to true and 0 flip to eval to false
            return new Flips(1, 0);
        }
        if (root.val == 1) {
            // since node is true, we need 0 flip to eval to true and 1 flip to eval to false
            return new Flips(0, 1);
        }

        // NOT
        if (root.val == 5) {
            // we inverse
            Flips flips;
            if (root.left != null) {
                flips = minFlips(root.left);
            } else {
                flips = minFlips(root.right);
            }
            // we reverse the flips of the child node
            return new Flips(flips.forFalse(), flips.forTrue());
        }
        Flips flipsLeft = minFlips(root.left);
        Flips flipsRight = minFlips(root.right);
        // OR
        if (root.val == 2) {
            int forTrueMin = flipsLeft.forTrue() + Math.min(flipsRight.forFalse(), flipsRight.forTrue());
            forTrueMin = Math.min(forTrueMin, flipsRight.forTrue() + Math.min(flipsLeft.forTrue(), flipsLeft.forFalse()));

            return new Flips(forTrueMin, flipsLeft.forFalse() + flipsRight.forFalse());
        }
        // AND
        if (root.val == 3) {
            
            int forFalseMin = flipsLeft.forFalse() + Math.min(flipsRight.forTrue(), flipsRight.forFalse());
            forFalseMin = Math.min(forFalseMin, flipsRight.forFalse() + Math.min(flipsLeft.forTrue(), flipsLeft.forFalse()));

            return new Flips(flipsLeft.forTrue() + flipsRight.forTrue(), forFalseMin);
        }
        // XOR
        if (root.val == 4) {
            int forFalseMin = flipsLeft.forTrue() + flipsRight.forTrue();
            forFalseMin = Math.min(forFalseMin, flipsLeft.forFalse() + flipsRight.forFalse());
            int forTrueMin = flipsLeft.forTrue() + flipsRight.forFalse();
            forTrueMin = Math.min(forTrueMin, flipsLeft.forFalse() + flipsRight.forTrue());
            return new Flips(forTrueMin, forFalseMin);
        }
        return null;
    }
}