/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node.right!=null){
            node = node.right;
            while(node.left!=null) node = node.left;
            return node;
        }
        while(node.parent!=null && node.parent.right==node){
            node = node.parent;
        }
        return node.parent;

    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root!=null){
            if(p.val>=root.val){
                root = root.right;
            }else{
                successor = root;
                root=root.left;
            }
        }
        return successor;
    }
}