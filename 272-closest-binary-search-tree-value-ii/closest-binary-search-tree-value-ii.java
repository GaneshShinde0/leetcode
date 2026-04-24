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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> treeNodes = new ArrayList<>();
        inOrder(root, treeNodes);
        PriorityQueue<Integer> pq = new PriorityQueue<>((b,a)->{
            return Double.compare(Math.abs(a-target), Math.abs(b-target));
        });
        
        for(int i:treeNodes){
            pq.add(i);
            while(pq.size()>k){
                pq.poll();
            }
        }
        // System.out.println(pq);
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()) result.add(pq.poll());
        return result;
    }

    void inOrder(TreeNode root, List<Integer> treeNodes){
        if(root==null) return;
        inOrder(root.left, treeNodes);
        treeNodes.add(root.val);
        inOrder(root.right, treeNodes);
    }
}