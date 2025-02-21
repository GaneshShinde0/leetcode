/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {

    TreeNode root;
    Set<Integer> hs = new HashSet<>();
    public FindElements(TreeNode root) {
        this.root = root;
        if(root!=null){
            this.root.val=0;
            setValues(root,0);
        }
    }
    // DFS
    public void setValues(TreeNode node, int val){
        if(node !=null ) {
            this.hs.add(val);
            node.val = val;
            setValues(node.left,val*2+1);
            setValues(node.right,val*2+2);
        }
        return;
    }
    
    private void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);
        while(queue.isEmpty()){
            TreeNode curr = queue.remove();
            hs.add(curr.val);
            if(curr.left!=null){
                curr.left.val = curr.val*2+1;
                queue.add(curr.left);
            }
            if(curr.right!=null){
                curr.right.val = curr.val*2+2;
                queue.add(curr.right);
            }
        }
    }
    public boolean find(int target) {
        return this.hs.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
