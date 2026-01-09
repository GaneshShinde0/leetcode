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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode curr = head, prev = null;
        while(m>1){
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode con = prev, tail = curr;
        ListNode third = null;
        // Iteratively traverse nodes until n becomes 0
        while(n>0){
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
            n--;
        }
        if(con!=null) con.next=prev;
        else head = prev;
        tail.next = curr;
        return head;
    }
}