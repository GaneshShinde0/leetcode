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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if(root==null) return null;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int n = dq.size();
            boolean foundU = false;
            for(int i=0;i<n;i++){
                TreeNode node = dq.pollFirst();
                if(node.left!=null) dq.add(node.left);
                if(foundU && node.left!=null) return node.left;
                if(!dq.isEmpty() && dq.peekLast()==u) foundU=true;
                if(node.right!=null) dq.add(node.right);
                if(foundU && node.right!=null) return node.right;
                if(!dq.isEmpty() && dq.peekLast()==u) foundU=true;
                // printDeque(dq);
            }
            if(foundU) return null;
        }
        return null;
    }
    public static void printDeque(Deque<TreeNode> dq) {
        for (TreeNode node : dq) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }


}