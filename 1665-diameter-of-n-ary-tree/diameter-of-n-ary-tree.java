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
    private int diameter = 0;
    public int diameter(Node root) {
        height(root);
        return diameter;
    }
    private int height(Node root){
        if(root==null) return 0;
        int max1 = 0, max2 = 0;
        for(Node child: root.children){
            int curr = height(child)+1;
            if(curr>max1){
                max2=max1;
                max1=curr;
            }else if(curr>max2){
                max2=curr;
            }
        }
        diameter = Math.max(max1+max2,diameter);
        return max1;
    }
}