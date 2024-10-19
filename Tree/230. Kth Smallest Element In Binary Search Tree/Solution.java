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
    public int kthSmallestWillWorkOnAnyBinaryTree(TreeNode root, int k) {
       List<Integer> li = new ArrayList<>();
       addNodes(li,root); 
       if(li.size()==1 && k==1) return li.get(0);
       Collections.sort(li);
       int j=0;
       int i=1;
       for(;i<li.size();i++){
            if(li.get(i)>li.get(i-1)) {
                j++;
                if(j==k)return li.get(i-1);
            }
       }
       j++;
    //    System.out.println("J: "+j+", K:"+k);
       if(j==k) return li.get(i-1);
       return -1;
    }
    public void addNodes(List<Integer> li,TreeNode root){
        if(root!=null) li.add(root.val);
        if(root==null)return;
        if(root.left!=null) addNodes(li,root.left);
        if(root.right!=null) addNodes(li,root.right);
    }


    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        traverse(root.left, k);
        //---------- real code starts here ----------
        count++;
        if(count == k) {
            result = root.val;
            return;
        }       
        //-------------------------------------------
        traverse(root.right, k);       
    }
}
