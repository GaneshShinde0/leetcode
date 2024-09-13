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
    public int maxDepth(Node root) {
        if(root==null) return 0;
        int max=1;
        for(Node child:root.children){
            max = Math.max(maxDepth(child)+1,max);
        }
        return max;
    }

    public int maxDepthIterativeBFS(Node root) {
         if (root == null) return 0;
        
         Queue<Node> queue = new LinkedList<>();
         queue.offer(root);
         int level = 0;
         while (!queue.isEmpty()){
            int size = queue.size();
             for (int i=0;i<size;i++){
                 Node node = queue.poll();
                 for(Node n: node.children)
                     queue.offer(n);
             }
             level++;
         }
         return level;
     }
    
    public int maxDepthDFS(Node root) {
         if(root == null) return 0;
         
         Stack<Node> stack = new Stack<>();
         Stack<Integer> depth = new Stack<>();
         stack.push(root);
         depth.push(1);
         int max = 1;
        
         while(!stack.isEmpty()) {
             Node n = stack.pop();
             int d = depth.pop();
            
             for(Node node: n.children) {
                 max = Math.max(d + 1, max);
                 stack.push(node);
                 depth.push(d + 1);
             }
         }
        return max;
     }
     
}
