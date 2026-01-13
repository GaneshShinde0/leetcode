/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        addParent(root,null);
        List<Integer> answer = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        dfs(target,k,answer,visited);
        return answer;
    }

    private void addParent(TreeNode curr, TreeNode parent){
        if(curr!=null){
            this.parent.put(curr, parent);
            addParent(curr.left, curr);
            addParent(curr.right, curr);
        }
    }

    private void dfs(TreeNode curr, int distance, List<Integer> answer, Set<TreeNode> visited){
        if(curr==null||visited.contains(curr)) return;
        visited.add(curr);
        if(distance ==0){
            answer.add(curr.val);
            return;
        }

        dfs(parent.get(curr), distance-1, answer, visited);
        dfs(curr.left, distance-1, answer, visited);
        dfs(curr.right, distance-1, answer, visited);
    }
}