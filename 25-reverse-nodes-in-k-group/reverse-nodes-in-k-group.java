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
    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode newHead = null;
        ListNode ptr = head;

        while(k>0){
            ListNode nextNode = ptr.next;
            ptr.next = newHead;
            newHead=ptr;
            ptr = nextNode;
            k--;
        }  
        return newHead; 
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;
        while(count<k && ptr!=null){
            ptr = ptr.next;
            count++;
        }
        if(count == k){
            ListNode reversedHead = this.reverseLinkedList(head, k);
            head.next = this.reverseKGroup(ptr,k);
            return reversedHead;
        }
        return head;
    }

}