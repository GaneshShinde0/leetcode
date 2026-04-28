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
    public Node flipBinaryTree(Node root, Node leaf) {
        Node originalRoot = root;
        return helper(leaf, originalRoot, null);// New parent of the leeft node is null
    }

    public Node helper(Node node, Node originalRoot, Node newParent){
        Node oldParent = node.parent;
        node.parent = newParent;

        if(node.left == newParent) node.left = null;
        if(node.right == newParent) node.right = null;

        if(node == originalRoot) return node;

        if(node.left!=null) node.right = node.left;
        node.left = helper(oldParent, originalRoot, node);
        return node;
    }
}