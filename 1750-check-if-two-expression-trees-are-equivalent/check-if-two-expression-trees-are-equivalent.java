/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] freq1 = new int[256], freq2 = new int[256];
        inOrder(freq1,root1);
        inOrder(freq2,root2);
        return Arrays.equals(freq1,freq2);
    }
    private void inOrder(int[] freq, Node root){
        if(root==null) return;
        freq[root.val]++;
        inOrder(freq, root.left);
        inOrder(freq, root.right);
    }
}