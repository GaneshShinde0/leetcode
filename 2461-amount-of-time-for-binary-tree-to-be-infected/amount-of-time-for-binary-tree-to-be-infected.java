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

    // Approach 1: Convert to Graph and BFS
    // We can consider tree as undirected graph.

    // Function to convert tree to graph.
    public void convert(TreeNode current, int parent, Map<Integer, Set<Integer>> map){
        if(current == null) return ;
        if(!map.containsKey(current.val)) map.put(current.val, new HashSet<>());
        Set<Integer> adjacentList = map.get(current.val);
        if(parent!=0) adjacentList.add(parent);
        if(current.left!=null) adjacentList.add(current.left.val);
        if(current.right!=null) adjacentList.add(current.right.val);

        convert(current.left, current.val, map);
        convert(current.right, current.val, map);
    }

    public int amountOfTime(TreeNode root, int start){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        convert(root, 0, map);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int minute = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                int current = queue.poll();
                for(int num:map.get(current)){
                    if(!visited.contains(num)){
                        visited.add(num);
                        queue.add(num);
                    }
                }
            }
            minute++;
        }
        return minute-1;
    }






























    public int amountOfTimeDoesNotWork(TreeNode root, int start) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depthOfLeft = 0, depthOfStart = -1;
        if(root.left!=null) queue.add(root.left);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.val==start) depthOfStart = depthOfLeft+1;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            depthOfLeft++;
        }
        depthOfLeft--;
        int result = -1;
        if(depthOfStart!=-1){
            result = Math.max(depthOfLeft-depthOfStart, depthOfStart);
        }
        int depthOfRight = 0;
        if(root.right!=null) queue.add(root.right);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                if(node.val==start) depthOfStart = depthOfRight+1;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            depthOfRight++;
        }
        depthOfRight--;
        if(root.val == start) return Math.max(depthOfLeft,depthOfRight)+1;
        if(result!=-1){
            result = Math.max(result,result + depthOfRight);
        }else{
            result = Math.max(depthOfRight-depthOfStart, depthOfStart);
            result = Math.max(result, result+depthOfLeft);
        }
        return result+1;
    }
}

