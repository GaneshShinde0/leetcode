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

class NaryTreelevelOrderTraversal {
    public List<List<Integer>> levelOrder3ms(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                for (Node child : currentNode.children) {
                    queue.offer(child);
                }
            }
            result.add(currentLevel);
        }
        
        return result;
    }


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }

    public void dfs (List<List<Integer>> result, Node root, int level){
        if (root == null) return;

        if (level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        for(Node node: root.children){
            dfs(result, node, level+1);
        }
    } 
}
