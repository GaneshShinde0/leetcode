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
    int carry = 0;
    public ListNode doubleIt(ListNode head) {
        getProd(head,2);
        if(carry>0){
            ListNode carryNode = new ListNode(carry);
            carryNode.next = head;
            return carryNode;
        }else{
            return head;
        }
    }

    private void getProd(ListNode head,int mult){
        if(head == null) return;
        getProd(head.next, mult);
        int temp = carry;
        carry = (head.val*mult+temp)/10;
        head.val = (head.val*mult+temp)%10;
    }
}