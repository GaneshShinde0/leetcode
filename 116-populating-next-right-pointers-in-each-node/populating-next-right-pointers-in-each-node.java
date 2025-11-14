/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            Node prev = queue.poll();
            if(prev.left!=null) queue.add(prev.left);
            if(prev.right!=null) queue.add(prev.right);
            for(int i=1;i<n;i++){
                Node curr = queue.poll();
                prev.next = curr;
                prev = curr;
                if(prev.left!=null) queue.add(prev.left);
                if(prev.right!=null) queue.add(prev.right);
            }
        }
        return root;
    }
}