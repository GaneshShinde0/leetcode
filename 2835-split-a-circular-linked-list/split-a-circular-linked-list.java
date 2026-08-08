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
    public ListNode[] splitCircularLinkedList(ListNode list) {
        ListNode head = list;
        int len = 1;
        while(list.next!=head){
            list = list.next;
            len++;
        }
        ListNode last = list;
        list = head;
        int i = 1;
        while(i<((len+1)/2)){
            list = list.next;
            i++;
        }
        ListNode head2 = list.next;
        last.next = head2;
        list.next = head;
        return new ListNode[]{head, head2};
    }
}