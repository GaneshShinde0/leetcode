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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k==0){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = head;
        dummy.next = head;
        int n = 0;
        while(head!=null){
            if(head!=null) tail = head;
            head = head.next;
            n++;
        }
        k=k%n;
        if(k==0) return dummy.next;
        int temp = 1;
        ListNode curr = dummy.next;
        while(temp<(n-k)){
            curr = curr.next;
            temp++;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = dummy.next;
        return newHead;
    }
}