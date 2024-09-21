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
class Solution {
    public List<List<Integer>> levelOrderBottomUsingSimpleReversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left); // Both add and offer add, difference between them is 
                if(node.right!=null) queue.offer(node.right);
                temp.add(node.val);
            }
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        // Step 1: Find the maximum depth of the tree
        int maxDepth = findMaxDepth(root);
        
        // Step 2: Initialize the result list with empty lists for each level
        for (int i = 0; i < maxDepth; i++) {
            res.add(new ArrayList<>());
        }
        
        // Step 3: Fill the result list using DFS, starting from root
        populateLevels(root, res, 0, maxDepth - 1);
        
        return res;
    }

    // Function to find the maximum depth of the tree
    private int findMaxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(findMaxDepth(node.left), findMaxDepth(node.right)) + 1;
    }

    // DFS function to populate the levels in bottom-up order
    private void populateLevels(TreeNode node, List<List<Integer>> res, int currDepth, int maxDepth) {
        if (node == null) return;
        
        // Add the node's value to the appropriate list (from the bottom-up)
        res.get(maxDepth - currDepth).add(node.val);
        
        // Traverse left and right children
        populateLevels(node.left, res, currDepth + 1, maxDepth);
        populateLevels(node.right, res, currDepth + 1, maxDepth);
    }

    public List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
