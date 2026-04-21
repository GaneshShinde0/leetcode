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

Given an integer n, our task is to return all unique BSTs that have exactly n nodes of unique values from 1 to N.

Approach 1: Recursive Dynamic Programming
Intuition:
In each node of a BST all values in the left subtree are smaller and all values in the right subtree are greater.
To find all the possible permutations of BSTs with n nodes, we can lock one node as the root node and split n-1 nodes between the left and right subtrees in all possible wasys. Let's say we place a node with value i as the root node and place i-1 nodes having values from 1 to i-1 in the left subtree (if i==1) the left child is null. Similarly we place remainign n-i nodes having values from i+1 to n in the right subtree (if i==n the right child is null).

Now we create a list of nodes called leftSubtrees for all the possible BSTs that could be the left sutree, similarly we create a list of nodes called rightSubTrees for all the BSTs that could be the right subtree.

In a BST, every subtree is also a BST.

We iterate over both the lists and for each node l in leftSubTrees and r in rightSubTrees, we create a new root node with value  and set the left and right child of root to l and r respectively to form all the BSTs with the root node as i.

We can iterate over the root's value from i= 1 to n and repeat the process for each root value to get all the BSTs.

You may notice that subproblem of finding the arrays leftSubTrees and rightSubTrees are similar to the original problem. We can implement this approach using recursion as we are breakign down a problem with n nodes to smaller. repetitive subproblems with i-1 and n-i nodes for(i=1 till n) to
*/
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return recurse(1,n);
    }

    private List<TreeNode> recurse(int left, int right){
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(left>right){
            res.add(null);
            return res;
        }
        for(int i=left;i<=right;i++){
            List<TreeNode> leftSubtrees = recurse(left,i-1);
            List<TreeNode> rightSubtrees = recurse(i+1,right);
            for(TreeNode leftSub:leftSubtrees){
                for(TreeNode rightSub:rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSub;
                    root.right = rightSub;
                    res.add(root);
                }
            }
        }
        return res;
    }
}