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
class Solution{
    public boolean isCompleteTree(TreeNode root){
        if(root==null) return true;
        boolean nullFound = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                nullFound = true;
            }else{
                if(nullFound) return false;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
class Solution1 {
    boolean isComplete;
    public boolean isCompleteTree(TreeNode root) {
        return dfs(root, 0, countNodes(root));
    }
    private boolean dfs(TreeNode node, int index, int n){
        if(node == null) return true;
        // If index assigned to the current node is greater than or equal to the number of nodes in tree, then the given tree is not a complete binary tree.
        if(index>=n) return false;
        return dfs(node.left, 2*index+1, n) && dfs(node.right, 2*index+2,n);
    }
    public int countNodes(TreeNode root){
        if(root==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}