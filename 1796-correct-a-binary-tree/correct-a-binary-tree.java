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
    public TreeNode correctBinaryTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean found = false;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.right!=null && nodeToParent.containsKey(node.right)){
                    TreeNode parent = nodeToParent.get(node) ;
                    if(parent.left==node){
                        parent.left=null;
                    }else{
                        parent.right=null;
                    }
                    return root;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    nodeToParent.put(node.right,node);
                }
                if(node.left!=null){
                    queue.add(node.left);
                    nodeToParent.put(node.left,node);
                }
            }
        }
        return root;
    }
}