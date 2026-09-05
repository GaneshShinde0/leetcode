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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        formGraph(root, graph);
        if(graph.size()==0) return root.val;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[1001];
        queue.add(k);
        vis[k] = true;
        while(!queue.isEmpty()){
            int n =queue.size();
            for(int i=0;i<n;i++){
                Integer curr = queue.poll();
                if(curr!=root.val && graph.get(curr).size()==1) return curr;
                for(Integer nei:graph.get(curr)){
                    if(!vis[nei]) queue.add(nei);
                    vis[nei] = true;
                }
            }
        }
        return root.val;
    }
    private void formGraph(TreeNode root, Map<Integer,Set<Integer>> graph){
        if(root==null) return;
        if(root.left!=null){
            graph.computeIfAbsent(root.val,x-> new HashSet<>()).add(root.left.val);
            graph.computeIfAbsent(root.left.val,x-> new HashSet<>()).add(root.val);
            formGraph(root.left,graph);
        }
        if(root.right!=null){
            graph.computeIfAbsent(root.val,x-> new HashSet<>()).add(root.right.val);
            graph.computeIfAbsent(root.right.val,x-> new HashSet<>()).add(root.val);
            formGraph(root.right,graph);
        }
    }
}