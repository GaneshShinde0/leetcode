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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        int currM = m;
        int currN = n;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;

        while(head!=null){
            while(head!=null && currM!=1){
                head=head.next;
                currM--;
            }
            if(head==null) continue;
            ListNode mid = head;
            while(head!=null && currN!=0){
                head=head.next;
                currN--;
            }
            if(head!=null) head = head.next;
            currM = m;
            currN = n;
            mid.next = head;
        }
        return dummy.next;
    }
}