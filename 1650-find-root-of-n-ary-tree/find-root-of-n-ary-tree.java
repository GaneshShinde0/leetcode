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
    public Node findRoot(List<Node> tree) {
        HashMap<Node,HashSet<Node>> childToParent = new HashMap<>();
        for(Node node:tree){
            for(Node child: node.children){
                childToParent.computeIfAbsent(child, x->new HashSet<Node>()).add(node);
            }
        }
        for(Node node:tree){
            if(!childToParent.containsKey(node)) return node;
        }
        return null;
    }
}

class SolutionSpaceOptimized{
    public Node findRoot(List<Node> tree) {

        Integer valueSum = 0;

        for (Node node : tree) {
            // the value is added as a parent node
            valueSum += node.val;
            for (Node child : node.children)
                // the value is deducted as a child node.
                valueSum -= child.val;
        }

        Node root = null;
        // the value of the root node is `valueSum`
        for (Node node : tree) {
            if (node.val == valueSum) {
                root = node;
                break;
            }
        }
        return root;
    }
}