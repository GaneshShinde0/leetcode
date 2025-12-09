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
    public ListNode removeNthFromEndOld(ListNode head, int n) {
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


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        while(head!=null){
            size++;
            head = head.next;
        }
        // if(size==1) return null;
        int k = size-n;
        int i=-1;
        head = temp;
        while(i<k-1){
            i++;
            head = head.next;
        }
        if(head.next!=null) head.next=head.next.next;
        return temp.next;
    }




















}