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
    public ListNode oddEvenList(ListNode head) {
        if (head == null||head.next==null) return head;
        ListNode evenNode = head;
        ListNode oddNode = head.next;
        ListNode oddHead = head.next;
        while(oddNode!=null&&oddNode.next!=null){
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
            oddNode.next = oddNode.next.next;
            oddNode = oddNode.next;
        }
        evenNode.next = oddHead;
        return head;
    }
}