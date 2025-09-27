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
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 1;
        Queue<TreeNode> q = new LinkedList<>();
        int res = 1;
        int currLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            int levelSum = 0;
            for(int i=0;i<n;i++){
                TreeNode curr = q.poll();
                levelSum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(levelSum>maxSum){
                maxSum = levelSum;
                res = currLevel;
            }
            currLevel++;
        }
        return res;
    }

    public int maxLevelSumDFS(TreeNode root) {
        List<Integer> levelSums = new ArrayList<>();
        dfs(root, 0, levelSums);

        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 1;
        for (int i = 0; i < levelSums.size(); i++) {
            if (levelSums.get(i) > maxSum) {
                maxSum = levelSums.get(i);
                resultLevel = i + 1; // +1 because levels are 1-indexed
            }
        }
        return resultLevel;
    }

    private void dfs(TreeNode node, int level, List<Integer> levelSums) {
        if (node == null) return;

        // Expand list if we're visiting this level for the first time
        if (level == levelSums.size()) {
            levelSums.add(0);
        }

        // Add current node's value to its level sum
        levelSums.set(level, levelSums.get(level) + node.val);

        // Go deeper into left and right subtrees
        dfs(node.left, level + 1, levelSums);
        dfs(node.right, level + 1, levelSums);
    }
}