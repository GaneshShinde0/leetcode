class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node){
        if(node==null) return 0;

        // If the left subtree was unbalanced (-1), return -1 immediately to stop further processing.
        int leftHeight = height(node.left);
        if(leftHeight == -1 ) return -1;

        int rightHeight = height(node.right);
        if(rightHeight == -1) return -1;

        // If the current node has an unbalanced difference in heights, return -1.
        if(Math.abs(leftHeight-rightHeight)>1) return -1;

        return Math.max(leftHeight, rightHeight)+1;
    }
}
