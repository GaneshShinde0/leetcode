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

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        if(root==null) return "";
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                Node curr = queue.poll();
                sb.append(curr.val).append(",").append(curr.children==null?0:curr.children.size()).append(" ");
                if(curr.children==null) continue;
                for(Node child:curr.children){
                    queue.add(child);
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.equals("")) return null;
        String[] arr = data.split(" ");
        Queue<Node> queueN = new LinkedList<>();
        Queue<Integer> queueI = new LinkedList<>();
        String[] curr = arr[0].split(",");
        int val = Integer.parseInt(curr[0]);
        int size = Integer.parseInt(curr[1]);
        Node node = new Node(val);
        queueN.add(node);
        queueI.add(size);
        int idx = 1;
        while(!queueN.isEmpty()){
            int n = queueN.size();
            for(int i=0;i<n;i++){
                Node currNode = queueN.poll();
                int childrenSize = queueI.poll();
                    List<Node> li = new ArrayList<>();
                    for(int j=0;j<childrenSize;j++){
                        curr = arr[idx].split(",");
                        val = Integer.parseInt(curr[0]);
                        size = Integer.parseInt(curr[1]);
                        Node childNode = new Node(val);
                        queueN.add(childNode);
                        queueI.add(size);
                        li.add(childNode);
                        idx++;
                    }
                    currNode.children = li;
            }
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));