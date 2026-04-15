/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */
class Solution {
    // Hashmap to map old tree's nodes with new tree's nodes.
    private HashMap<Node, NodeCopy> seen = new HashMap<>();

    private  NodeCopy dfs(Node root) {
        if (root == null) return null;
        if (seen.containsKey(root)) return seen.get(root);
        NodeCopy newRoot = new NodeCopy(root.val);
        // Mark old root as seen and store its respective new node.
        seen.put(root, newRoot);
        
        // Traverse on all 3 edges of root and attach respective new node to the newRoot.
        newRoot.left = dfs(root.left);
        newRoot.right = dfs(root.right);
        newRoot.random = dfs(root.random);
        return newRoot;
    }

    public NodeCopy copyRandomBinaryTree(Node root) {
        // Traverse on each node of the given tree.
        NodeCopy newRoot = dfs(root);
        return newRoot;
    }
}
class SolutionInitial {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root ==null) return null;
        HashMap<Node,NodeCopy> hm = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        NodeCopy node;
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            node = new NodeCopy();
            node.val = curr.val;
            hm.put(curr, node);
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
        }

        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            node = hm.get(curr);
            node.left = hm.get(curr.left);
            node.right = hm.get(curr.right);
            node.random = hm.get(curr.random);
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
        }
        return hm.get(root);
    }
}