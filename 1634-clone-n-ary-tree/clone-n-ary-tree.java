/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        if(root==null) return null;
        HashMap<Node,Node> hm = new HashMap<>();
        Stack<Node> stk = new Stack<>();
        hm.put(root,new Node(root.val));
        stk.add(root);
        while(!stk.isEmpty()){
            Node curr = stk.pop();
            Node newNode = hm.get(curr);
            for(Node child:curr.children){
                Node newChild = new Node(child.val);
                newNode.children.add(newChild);
                hm.put(child,newChild);
                stk.add(child);
            }
        }
        return hm.get(root);
    }
}