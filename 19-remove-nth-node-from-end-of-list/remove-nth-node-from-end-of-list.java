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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len =0;
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        temp.next = head;
        temp=temp.next;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        temp = node;
        int k=len-n;
        while(k>0){
            k--;
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return node.next;
    }
}