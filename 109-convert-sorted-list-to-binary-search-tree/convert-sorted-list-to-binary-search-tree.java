/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBSTRevisitLater(ListNode head) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode root = null;
        while(head!=null){
            TreeNode node = new TreeNode(head.val);
            if(stk.isEmpty()){
                stk.push(node);
                head = head.next;
            }else{
                if(stk.peek().val<head.val){
                    node.left = stk.pop();
                    stk.push(node);
                }else{
                    root = stk.peek();
                    root.right = node;
                    root = root.right;
                }
            }
        }
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode midNode = getMiddle(head);
        TreeNode mid = new TreeNode(midNode.val);
        ListNode temp= midNode.next;
        mid.left = sortedListToBST(head);
        mid.right = sortedListToBST(temp);
        return mid;

    }

    public ListNode getMiddle(ListNode head){
        ListNode fast = head, slow = head,prev=null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev!=null) prev.next=null;
        return slow;
    }
}