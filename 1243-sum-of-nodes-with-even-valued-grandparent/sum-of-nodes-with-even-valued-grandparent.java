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
 Sum = 0+2+7+1+3+5
    dfs(2,6,7) 
        sum+=2
        dfs(9,7,2)=>0
        dfs(null,7,2)=>0
    dfs(7,6,7)
        sum+=7
        dfs(1,7,7)=>0
        dfs(4,7,7)=>0

    dfs(1,6,8)
        sum+=1
        dfs(null,8,1)=>0
        dfs(null,8,1)=>0
    dfs(3,6,8)
        sum+=3
        dfs(null,8,3);
        dfs(5,8,3);=+5
 */
class SolutionInitial {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root.left!=null){
            dfs(root.left.left,root,root.left);
            dfs(root.left.right, root,root.left);
        }
        if(root.right!=null){
            dfs(root.right.left, root,root.right);
            dfs(root.right.right, root,root.right);
        }
        return sum;
    }

    private void dfs(TreeNode curr, TreeNode grandParent, TreeNode parent){
        if(curr==null) return;
        if(grandParent!=null && grandParent.val%2==0){
            sum+=curr.val;
        }
        if(curr!=null){
            dfs(curr.left,parent, curr);
            dfs(curr.right, parent, curr);
        }
    }
}

class Solution{
    int sum;
    public int sumEvenGrandparent(TreeNode root){
        this.sum = 0;
        dfs(root,null,null);
        return sum;
    }

    private void dfs(TreeNode curr, TreeNode parent, TreeNode grandParent){
        if(curr==null) return;
        if(grandParent!=null && grandParent.val%2==0){
            sum+=curr.val;
        }
        dfs(curr.left, curr, parent);
        dfs(curr.right, curr, parent);
    }
}