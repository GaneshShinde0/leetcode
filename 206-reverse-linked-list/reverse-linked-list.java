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
    public ListNode reverseListInitial(ListNode head) {
        if(head==null) return null;
        Stack<ListNode> stk = new Stack<>();
        while(head.next!=null){
            stk.add(head);
            head = head.next;
        }
        stk.add(head);
        ListNode temp = new ListNode(-1);
        ListNode curr=temp;
        while(!stk.isEmpty()){
            curr.next = stk.pop();
            curr=curr.next;
            curr.next = null; // ImportantToAvoidCycles
        }
        return temp.next;
    }

    // Iterative Inplace
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head=temp;
        }
        return prev;
    }
}