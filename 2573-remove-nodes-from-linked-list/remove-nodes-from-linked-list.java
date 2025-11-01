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
class Solution {
    public ListNode removeNodesStack(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stk = new Stack<>();
        while(curr!=null){
            while(!stk.isEmpty() && stk.peek().val<curr.val){
                stk.pop();
            }
            stk.push(curr);
            curr = curr.next;
        }

        // Reversing the stack.
        ListNode next = null;
        while(!stk.isEmpty()){
            curr = stk.pop();
            curr.next = next;
            next = curr;
        }
        return curr;
    }

    public ListNode removeNodes(ListNode head){
        if(head == null) return null; // Base condition for recursion
        ListNode node = head;
        ListNode nextGreater = removeNodes(node.next);
        node.next = nextGreater;
        if(nextGreater==null || node.val>=nextGreater.val) return node;
        return nextGreater;
    }
}