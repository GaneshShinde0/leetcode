class Solution {
    void DFS(TreeNode root, boolean isLonely, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (isLonely) {
            ans.add(root.val);
        }
        DFS(root.left, root.right == null, ans);
        DFS(root.right, root.left == null, ans);
    }
    
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        DFS(root, false, ans);

        return ans;
    }
}