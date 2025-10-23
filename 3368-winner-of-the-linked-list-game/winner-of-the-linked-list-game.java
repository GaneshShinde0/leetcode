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
    public String gameResult(ListNode head) {
        int oddSum =0, evenSum = 0;
        while(head!=null){
            int val = head.val;
            head=head.next;
            int nextVal = head.val;
            if(val>nextVal) evenSum++;
            else if(val<nextVal) oddSum++;
            head = head.next;
        }
        return evenSum==oddSum?"Tie":evenSum>oddSum?"Even":"Odd";
    }
}