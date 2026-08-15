public class Solution {

    public int findDistance(TreeNode root, int p, int q) {
        // Find the lowest common ancestor of p and q.
        TreeNode lca = findLCA(root, p, q);
        return depth(lca, p) + depth(lca, q);
    }

    // Function to find the LCA of the given nodes.
    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    // Function to find the depth of the node with respect to LCA.
    private int depth(TreeNode root, int target) {
        return depth(root, target, 0);
    }

    private int depth(TreeNode root, int target, int currentDepth) {
        // Node not found
        if (root == null) {
            return -1;
        }
        if (root.val == target) {
            return currentDepth;
        }

        // Check left subtree
        int leftDepth = depth(root.left, target, currentDepth + 1);
        if (leftDepth != -1) {
            return leftDepth;
        }

        // If not in left subtree, it is guaranteed to be in right subtree
        return depth(root.right, target, currentDepth + 1);
    }
}