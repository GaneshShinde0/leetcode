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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();
        HashMap<Integer,Integer> inDegree = new HashMap<>();
        for(int[] desc:descriptions){
            int root = desc[0], child = desc[1], isLeft = desc[2];
            if(isLeft==1){
                left.put(root,child);
            }else{
                right.put(root,child);
            }
            inDegree.put(child,1);
        }
        int rootVal=-1;
        for(int[] desc:descriptions){
            int curr = desc[0], child = desc[1], isLeft = desc[2];
            if(inDegree.getOrDefault(curr,0)==0){
                rootVal = curr;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            int currVal = curr.val;
            if(left.containsKey(currVal)){
                curr.left = new TreeNode(left.get(currVal));
                queue.add(curr.left);
            }
            if(right.containsKey(currVal)){
                curr.right = new TreeNode(right.get(currVal));
                queue.add(curr.right);
            }
        }
        return root;
    }
}