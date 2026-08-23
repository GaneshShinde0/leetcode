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
class SolutionHashMap {
    HashMap<Integer,Integer> hm;
    public boolean checkEqualTree(TreeNode root) {
        this.hm = new HashMap<>();
        int sum = sum(root);
        if(sum%2!=0) return false; // On Negative numbers sum%2 gives -1 in java
        if(sum==0) return hm.getOrDefault(0,0)>=2;
        return hm.containsKey(sum/2);
    }
    private int sum(TreeNode root){
        if(root==null) return 0;
        int sum = root.val+sum(root.left)+sum(root.right);
        hm.put(sum,hm.getOrDefault(sum,0)+1);
        return sum;
    }
}
class Solution {
    HashSet<Integer> hs;
    
    public boolean checkEqualTree(TreeNode root) {
        hs = new HashSet<>();
        
        // Calculate total sum while only adding proper subtrees to the HashSet
        int totalSum = root.val + sum(root.left) + sum(root.right);
        
        // If the sum is odd (positive or negative), it can't be split equally
        if (totalSum % 2 != 0) return false;
        
        // Because the root's total sum isn't in the HashSet, 
        // a target sum will only be found if a proper subtree sums is present.
        return hs.contains(totalSum / 2);
    }
    
    private int sum(TreeNode root) {
        if (root == null) return 0;
        int currentSum = root.val + sum(root.left) + sum(root.right);
        hs.add(currentSum); // Add proper subtree sum
        return currentSum;
    }
}