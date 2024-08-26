/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> li = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        postOrderHelper(root);
        return li;
    }

    private void postOrderHelper(Node root){
        if (root==null) return;
        List<Node> childrens = root.children;
        for(int i=0;i<childrens.size();i++){
            postOrderHelper(childrens.get(i));
        }
        li.add(root.val);
    }
}
