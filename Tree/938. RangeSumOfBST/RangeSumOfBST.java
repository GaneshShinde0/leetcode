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
class RangeSumOfBST {
    public int rangeSumBSTIterative(TreeNode root, int low, int high) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum =0;{
            while(!stack.isEmpty()){
                TreeNode n= stack.pop();
                if (n==null){continue;}
                if(n.val> low){stack.push(n.left);}
                if(n.val< high){stack.push(n.right);}
                if(low<=n.val && n.val<=high){sum+=n.val;}
            }
        }
        return sum;
    }

    // Recursive (faster)
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else {
            return 0;
        }
    }
}
