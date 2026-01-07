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
    private Map<Integer, Integer> inOrderMap = new HashMap<>();
    private int[] postOrder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrder = postorder;
        int len = inorder.length;
        // Keeping indexes of inOrder aside for further actions
        for(int i=0;i<len;i++){
            inOrderMap.put(inorder[i],i);
        }
        return buildSubtree(0,0,len);
    }

    private TreeNode buildSubtree(int inOrderStart, int postOrderStart, int subtreeSize){
        if(subtreeSize<=0) return null;
        int rootValue = postOrder[subtreeSize+postOrderStart-1];
        int rootIndexInOrder = inOrderMap.get(rootValue);
        int leftSubtreeSize = rootIndexInOrder-inOrderStart;
        TreeNode leftChild = buildSubtree(inOrderStart, postOrderStart, leftSubtreeSize);
        TreeNode rightChild = buildSubtree(rootIndexInOrder+1, postOrderStart+leftSubtreeSize, subtreeSize-leftSubtreeSize-1);
        return new TreeNode(rootValue, leftChild, rightChild);
    }
}