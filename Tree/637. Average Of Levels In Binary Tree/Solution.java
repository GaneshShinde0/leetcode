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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> li= new LinkedList<>();
        li.add(root);
        while(!li.isEmpty()){
            int size = li.size();
            double sum = 0.0;
            for(int i=0;i<size;i++){
                TreeNode node = li.poll();
                if(node.left!=null) li.add(node.left);
                if(node.right!=null) li.add(node.right);
                sum+=node.val;
            }
            result.add(sum/size);
        }
        return result;
    }
}
