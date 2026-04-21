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
 /*
Given the root of a binary search Tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 */
class Solution {
    /*
    Approach 1: Sort an almost sorted array where two elements are swaped.

    - Inorder traversal of BST is an array sorted in ascending order.
        - Two nodes are swapped hence inroder traversal is alsmost sorted array where only two elements are swapped. 
        - Two swapped elements in sorted array can be solved by linear search

    Algorithm:
    1. Construct inorder traversal of the tree. It should be almost sorted list where only two elements are swapped.
    2. Identify two swapped elements x and y in almost sorted array in linear tiem.
    3. Traverse the tree again. Change value x to y and valye y to x.
    */
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int[] swapped = getSwapped(nums);
        recover(root, 2, swapped[0],swapped[1]);
    }
    public void recover(TreeNode root, int count, int x, int y){
        if(root!=null){
            if(root.val==x||root.val==y){
                root.val=root.val==x?y:x;
                if(--count==0) return;
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
    }
    private void inOrder(TreeNode root, List<Integer> nums){
        if(root==null) return;
        inOrder(root.left,nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
    private int[] getSwapped(List<Integer> nums){
        int[] res = new int[2];
        boolean foundFirst = false;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)<nums.get(i-1)){
                res[1] = nums.get(i);
                if(!foundFirst){
                    res[0]= nums.get(i-1);
                    foundFirst = true;
                }else{
                    break;
                }
            }
        }
        return res;
    }
}