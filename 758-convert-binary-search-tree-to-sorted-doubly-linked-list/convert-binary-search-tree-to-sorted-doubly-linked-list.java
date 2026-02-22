/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {

    // The smallest (first) and the largest (last) nodes;
    Node first = null;
    Node last = null;

    public void helper(Node node){
        if(node!=null){
            // Left
            helper(node.left);

            // Node
            if(last!=null){
                // Link the previous node (last) with current node (node);
                last.right = node;
                node.left = last;
            }else{
                // Keep the smallest node to close DLL later on
                first = node;
            }
            last = node;

            // right 
            helper(node.right);
        }
    }
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }
}

