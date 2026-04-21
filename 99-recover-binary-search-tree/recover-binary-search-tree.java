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
class Solution1 {
    /*
    Approach 1: Sort an almost sorted array where two elements are swaped.

    - Inorder traversal of BST is an array sorted in ascending order.
        - Two nodes are swapped hence inroder traversal is alsmost sorted array where only two elements are swapped. 
        - Two swapped elements in sorted array can be solved by linear search

    Algorithm:
    1. Construct inorder traversal of the tree. It should be almost sorted list where only two elements are swapped.
    2. Identify two swapped elements x and y in almost sorted array in linear tiem.
    3. Traverse the tree again. Change value x to y and valye y to x.

    Complexity Analysis:
    - Time Complexity: O(N) - Inorder takes O(N) to identify, O(N) to swap.
    - Space Complexity: O(N)
    */
    public void recoverTreeInitial(TreeNode root) {
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

    /*
    Approach 2:
    Same as above, without inOrder 
    */

    public void recoverTree(TreeNode root){
        Deque<TreeNode> stk = new ArrayDeque();
        TreeNode x = null, y = null, pred = null;
        while(!stk.isEmpty() || root!=null){
            while(root!=null){
                stk.add(root);
                root=root.left;
            }
            root = stk.removeLast();
            if(pred!=null && root.val<pred.val){
                y = root;
                if(x==null) x = pred;
                else break;
            }
            pred = root;
            root =  root.right;
        }
        swap(x,y);
    }
    public void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}

/*
Approach 3: Recursive Inorder Traversal
Iterative approach 2 could be converted into recursive one.

Recursive inorder traversal is " left->node->right" i.e. 
*/

class Solution2{
    TreeNode x = null, y = null, predecessor = null;
    public void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void findTwoSwapped(TreeNode root){
        if(root == null) return;
        findTwoSwapped(root.left);
        if(predecessor!=null && root.val<predecessor.val){
            y = root;
            if(x==null) x = predecessor;
            else return;
        }
        predecessor = root;
        findTwoSwapped(root.right);
    }
    public void recoverTree(TreeNode root){
        findTwoSwapped(root);
        swap(x, y);
    }
}

/*
Approach 4: Morris Inorder Traversal
- Iterative and receursive inorder traversals, which both have great time complexity through use up to O(N) to keep stack. We could trade in performance to save space.

The idea of Morris inorder traversal is simple: To use no space but to traverse the tree.
    - At each node one has to decide where to go: left or right, traverse left subtree or right.
    - How can we knw that the left subtree is already done if no additional memory is allowed.

The idea of Morris algorithm is to set the temporarary link between the node and its predecessor: predecesssor.right = root. So one starts from the node, computes its predecessor and verifies if the link is present.
- There is no link? Set it and go to the left subtree.
- There is a link? Break it and go to the right subtree.

Issue to deal: What if there is no left child, i.e. there is no left subtree? Then go straightforward to the right subtree.

*/

class Solution{

    public void recoverTree(TreeNode root){
        TreeNode x = null, y = null, pred = null, predecessor = null;
        while(root!=null){
            if(root.left!=null){
                predecessor = root.left;
                while(predecessor.right!=null && predecessor.right!=root) predecessor = predecessor.right;
                if(predecessor.right == null){
                    predecessor.right = root;
                    root = root.left;
                }else{
                    if(pred!=null && root.val<pred.val){
                        y = root;
                        if(x==null) x = pred;
                    }
                    pred = root;
                    predecessor.right = null;
                    root = root.right;
                }
            }else{
                if(pred!=null && root.val<pred.val){
                    y = root;
                    if(x==null) x = pred;
                }
                pred = root;
                root = root.right;
            }
        }
        swap(x,y);
    }

    private void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}