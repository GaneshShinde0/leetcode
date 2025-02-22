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
    int index;
    int n;
    public TreeNode recoverFromPreorder(String s) {
        this.index=0;
        this.n=s.length();
        return helper(s,0);
    }
    private TreeNode helper(String s, int depth){
        if(index>=n) return null;
        int dashCount = 0;
        while(index+dashCount<s.length()&&s.charAt(index+dashCount)=='-'){
            dashCount++;
        }
        if(dashCount!=depth) return null;
        index +=dashCount;

        int val = 0;
        while(index<n && Character.isDigit(s.charAt(index))){
            val=val*10+s.charAt(index++)-'0';
        }
        TreeNode node = new TreeNode(val);
        node.left = helper(s, depth+1);
        node.right = helper(s,depth+1);
        return node;
    }
}
