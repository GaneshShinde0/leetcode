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
    public int pathSumTLE(TreeNode root, int targetSum) {
        if(root==null) return 0;
        return pathSumTLE(root.left,targetSum)+pathSumTLE(root.right,targetSum)+helperTLE(root,0,targetSum);
    }

    private int helperTLE(TreeNode root, long current, long target){
        if (root==null) return 0;
        current+=root.val;
        return (current==target?1:0) + helperTLE(root.left,current, target)+helperTLE(root.right, current, target);
    }


    public int pathSum(TreeNode root, int targetSum) {
        if (root==null) return 0;
        Map<Long, Long> map = new HashMap<>();
        map.put(0l,1l);
        return (int) helper(root, 0, targetSum, map);
    }

    public long helper(TreeNode root, long current, long target, Map<Long, Long> map){
        if(root==null) return 0;
        current+=root.val;
        long count = 0;
        count += map.getOrDefault(current-target,0l);
        map.put(current, map.getOrDefault(current, 0l)+1);

        count += helper(root.left, current, target, map);
        count += helper(root.right, current, target, map);

        map.put(current, map.get(current)-1);
        return count;
    }

}