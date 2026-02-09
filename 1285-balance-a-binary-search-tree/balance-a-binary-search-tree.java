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
    public TreeNode balanceBSTInorderTraversalRecursiveConstruction(TreeNode root) {
        List<Integer> li =  new ArrayList<>();
        getNodesOfTree(li,root);
        return getBalancedTree(li,0, li.size()-1);
    }
    private void getNodesOfTree(List<Integer> li, TreeNode root){
        if(root==null) return;
        getNodesOfTree(li, root.left);
        li.add(root.val);
        getNodesOfTree(li, root.right);
    }
    private TreeNode getBalancedTree(List<Integer> li, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode leftSubTree = getBalancedTree(li,start,mid-1);
        TreeNode rightSubTree = getBalancedTree(li,mid+1,end);
        return new TreeNode(li.get(mid),leftSubTree, rightSubTree);
    }
    
    // Approach  2: Day-Stout-Warren Algorithm / In-Place Balancing
    public TreeNode balanceBST(TreeNode root){
        if(root == null) return null;

        // Step 1: Create the backbone (vine), Temporary dummy node
        TreeNode vineHead = new TreeNode(0);
        vineHead.right = root;
        TreeNode current = vineHead;
        while(current.right!=null){
            if(current.right.left!=null){
                rightRotate(current, current.right);
            }else{
                current = current.right;
            }
        }
        // Step 2: Count the Nodes
        int nodeCount = 0;
        current = vineHead.right;
        while(current!=null){
            ++nodeCount;
            current = current.right;
        }
        
        // Step 3: Create a balanced BST
        int m = (int) Math.pow(2, Math.floor(Math.log(nodeCount+1)/Math.log(2)))-1;
        makeRotations(vineHead, nodeCount-m);
        while(m>1){
            m/=2;
            makeRotations(vineHead,m);
        }

        TreeNode balancedRoot = vineHead.right;
        return balancedRoot;
    }

    // Perform a right rotation
    private void rightRotate(TreeNode parent, TreeNode node){
        TreeNode tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        parent.right = tmp;
    }

    // Perform a left rotation
    private void leftRotate(TreeNode parent, TreeNode node){
        TreeNode tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        parent.right = tmp;
    }

    // Function to perform a series of left rotations to balance the vine
    private void makeRotations(TreeNode vineHead, int count){
        TreeNode current = vineHead;
        for(int i=0;i<count;i++){
            TreeNode tmp = current.right;
            leftRotate(current, tmp);
            current = current.right;
        }
    }
}