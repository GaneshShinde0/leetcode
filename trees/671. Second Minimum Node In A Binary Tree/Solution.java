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
    public int findSecondMinimumValue(TreeNode root) {
       List<Integer> li = new ArrayList<>();
       addNodes(li,root); 
       Collections.sort(li);
       for(int i=0;i<li.size()-1;i++){
            if(li.get(i+1)>li.get(i)) return li.get(i+1);
       }
       return -1;
    }
    public void addNodes(List<Integer> li,TreeNode root){
        if(root!=null) li.add(root.val);
        if(root==null)return;
        if(root.left!=null) addNodes(li,root.left);
        if(root.right!=null) addNodes(li,root.right);
    }

    public int findSecondMinimumValueAlternate(TreeNode root) {
        if (root == null) return -1;
        return findSecondMin(root, root.val);
    }

    private int findSecondMin(TreeNode node, int minVal) {
        if (node == null) return -1;
        
        // If we find a node with a value greater than minVal, return that value
        if (node.val > minVal) return node.val;

        // Recur for left and right subtrees
        int leftSecondMin = findSecondMin(node.left, minVal);
        int rightSecondMin = findSecondMin(node.right, minVal);

        // If both sides have valid second minimums, return the smaller one
        if (leftSecondMin != -1 && rightSecondMin != -1) {
            return Math.min(leftSecondMin, rightSecondMin);
        }

        // Otherwise, return the valid second minimum (if any)
        return leftSecondMin != -1 ? leftSecondMin : rightSecondMin;
    }
}
