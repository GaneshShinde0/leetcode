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

class Solution{
    public List<Integer> closestKValues(TreeNode root, double target, int k){
        Deque<Integer> queue = new LinkedList<>();
        dfs(root, queue, k, target);
        return new ArrayList<>(queue);
    }

    public void dfs(TreeNode node, Deque<Integer> queue, int k, double target){
        if(node == null) return;
        dfs(node.left, queue, k, target);
        queue.add(node.val);
        if(queue.size()>k){
            if(Math.abs(target-queue.peekFirst())<=Math.abs(target-queue.peekLast())){
                queue.removeLast();
                return;
            }else{
                queue.removeFirst();
            }
        }
        dfs(node.right, queue,k,target);
    }
}
class SolutionOptimizeInitial2{
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> treeNodes = new PriorityQueue<>((b,a)->Double.compare(Math.abs(a-target), Math.abs(b-target)));
        inOrder(root, treeNodes, k);
        return new ArrayList<>(treeNodes);
    }

    void inOrder(TreeNode root, Queue<Integer> treeNodes, int k){
        if(root==null) return;
        inOrder(root.left, treeNodes,k);
        treeNodes.add(root.val);
        if(treeNodes.size()>k) treeNodes.poll();
        inOrder(root.right, treeNodes, k);
    }
}
 
class SolutionOptimizeInitial {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> treeNodes = new ArrayList<>();
        inOrder(root, treeNodes);
        Collections.sort(treeNodes,(a,b)->{
            return Double.compare(Math.abs(a-target), Math.abs(b-target));
        });
        return treeNodes.subList(0,k);
    }

    void inOrder(TreeNode root, List<Integer> treeNodes){
        if(root==null) return;
        inOrder(root.left, treeNodes);
        treeNodes.add(root.val);
        inOrder(root.right, treeNodes);
    }
}
class SolutionInitial {
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

