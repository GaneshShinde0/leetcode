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
class Solution1 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> li1 = new ArrayList<>(), li2 = new ArrayList<>(), res = new ArrayList<>();
        inOrder(root1, li1);
        inOrder(root2, li2);
        int p1 = 0, p2=0, size1 = li1.size(), size2 = li2.size();
        while(p1<size1 && p2<size2){
            if(li1.get(p1)<li2.get(p2)){
                res.add(li1.get(p1));
                p1++;
            }else{
                res.add(li2.get(p2));
                p2++;
            }
        }
        while(p1<size1){
            res.add(li1.get(p1));
            p1++;
        }
        while(p2<size2){
            res.add(li2.get(p2));
            p2++;
        }
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> li){
        if(root==null) return;
        inOrder(root.left, li);
        li.add(root.val);
        inOrder(root.right, li);
    }


}

class Solution{
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2){
        ArrayDeque<TreeNode> stk1 = new ArrayDeque();
        ArrayDeque<TreeNode> stk2 = new ArrayDeque();
        List<Integer> res = new ArrayList<>();

        while(root1!=null || root2 != null || !stk1.isEmpty() || !stk2.isEmpty()){
            while(root1 != null){
                stk1.push(root1);
                root1 = root1.left;
            }

            while(root2!=null){
                stk2.push(root2);
                root2 = root2.left;
            }

            if(stk2.isEmpty() || !stk1.isEmpty() && stk1.getFirst().val<=stk2.getFirst().val){
                root1 = stk1.pop();
                res.add(root1.val);
                root1 = root1.right;
            }else{
                root2 = stk2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;

    }
}