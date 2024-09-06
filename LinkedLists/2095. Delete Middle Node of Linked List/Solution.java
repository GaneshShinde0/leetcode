/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 * }
 */
class Solution {
    public ListNode deleteMiddle3ms(ListNode head) {
        if(head ==null||head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast!=null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next= slow.next;
        return head;
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode fast = head.next.next;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;

        return head;
    }
}
